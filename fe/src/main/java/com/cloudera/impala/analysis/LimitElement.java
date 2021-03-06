// Copyright 2013 Cloudera Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.cloudera.impala.analysis;

import com.cloudera.impala.analysis.Expr.SubstitutionMap;
import com.cloudera.impala.catalog.AuthorizationException;
import com.cloudera.impala.common.AnalysisException;
import com.cloudera.impala.common.InternalException;
import com.cloudera.impala.service.FeSupport;
import com.cloudera.impala.thrift.TColumnValue;
import com.google.common.base.Preconditions;

/**
 * Combination of limit and offset expressions.
 */
class LimitElement {
  private final Expr limitExpr_;
  private final Expr offsetExpr_;
  private long limit_;
  private long offset_;
  private boolean isAnalyzed_;

  /**
   * Constructs the LimitElement.
   * @param limitExpr The limit expression. May be null if there is no LIMIT clause.
   * @param offsetExpr The offset expression. May be null if there is no OFFSET clause,
   *                   but an OFFSET clause requires a LIMIT clause (this must not be
   *                   null if limit is null).
   */
  public LimitElement(Expr limitExpr, Expr offsetExpr) {
    Preconditions.checkArgument(offsetExpr == null || limitExpr != null);
    this.limitExpr_ = limitExpr;
    this.offsetExpr_ = offsetExpr;
    isAnalyzed_ = false;
    limit_ = -1;
    offset_ = 0;
  }

  public Expr getLimitExpr() { return limitExpr_; }
  public Expr getOffsetExpr() { return offsetExpr_; }

  /**
   * Returns the integer limit, evaluated from the limit expression. Must call analyze()
   * first. If no limit was set, then -1 is returned.
   */
  public long getLimit() {
    Preconditions.checkState(isAnalyzed_);
    return limit_;
  }

  public boolean hasLimit() {
    Preconditions.checkState(isAnalyzed_);
    return limit_ != -1;
  }

  /**
   * Returns the integer offset, evaluated from the offset expression. Must call
   * analyze() first. If no offsetExpr exists, then 0 (the default offset) is returned.
   */
  public long getOffset() {
    Preconditions.checkState(isAnalyzed_);
    return offset_;
  }

  public String toSql() {
    if (limitExpr_ == null) return "";
    StringBuilder sb = new StringBuilder(" LIMIT ");
    sb.append(limitExpr_.toSql());
    // Don't add the offset if it is the default value. However, we do print it if it
    // hasn't been analyzed yet because we need to output the expression used in errors.
    if (offsetExpr_ != null && (offset_ != 0 || !isAnalyzed_)) {
      sb.append(" OFFSET ");
      sb.append(offsetExpr_.toSql());
    }
    return sb.toString();
  }

  public void analyze(Analyzer analyzer) throws AuthorizationException,
      AnalysisException {
    isAnalyzed_ = true;
    if (limitExpr_ == null) return;
    if (!limitExpr_.isConstant()) {
      throw new AnalysisException("LIMIT expression must be a constant expression: " +
          limitExpr_.toSql());
    }
    if (offsetExpr_ != null && !offsetExpr_.isConstant()) {
      throw new AnalysisException("OFFSET expression must be a constant expression: " +
          offsetExpr_.toSql());
    }

    limitExpr_.analyze(analyzer);
    if (!limitExpr_.getType().isIntegerType()) {
      throw new AnalysisException("LIMIT expression must be an integer type but is '" +
          limitExpr_.getType() + "': " + limitExpr_.toSql());
    }
    limit_ = evalIntegerExpr(analyzer, limitExpr_, "LIMIT");

    if (offsetExpr_ != null) {
      offsetExpr_.analyze(analyzer);
      if (!offsetExpr_.getType().isIntegerType()) {
        throw new AnalysisException("OFFSET expression must be an integer type but " +
            "is '" + offsetExpr_.getType() + "': " + offsetExpr_.toSql());
      }
      offset_ = evalIntegerExpr(analyzer, offsetExpr_, "OFFSET");
    }
  }

  public LimitElement clone(SubstitutionMap sMap) {
    LimitElement e = new LimitElement(
        limitExpr_ == null ? null : limitExpr_.clone(sMap),
        offsetExpr_ == null ? null : offsetExpr_.clone(sMap));
    return e;
  }

  /**
   * Evaluations an expression to a non-zero integral value, returned as a long. Throws
   * if the expression cannot be evaluated, if the value evaluates to null, or if the
   * result is negative. The 'name' parameter is used in exception messages, e.g.
   * "LIMIT expression evaluates to NULL".
   */
  private static long evalIntegerExpr(Analyzer analyzer, Expr expr, String name)
      throws AnalysisException {
    TColumnValue val = null;
    try {
      val = FeSupport.EvalConstExpr(expr, analyzer.getQueryContext());
    } catch (InternalException e) {
      throw new AnalysisException("Failed to evaluate expr: " + expr.toSql(), e);
    }
    long value;
    if (val.isSetLong_val()) {
      value = val.getLong_val();
    } else if (val.isSetInt_val()) {
      value = val.getInt_val();
    } else if (val.isSetShort_val()) {
      value = val.getShort_val();
    } else if (val.isSetByte_val()) {
      value = val.getByte_val();
    } else {
      throw new AnalysisException(name + " expression evaluates to NULL: " +
          expr.toSql());
    }
    if (value < 0) {
      throw new AnalysisException(name + " must be a non-negative integer: " +
          expr.toSql() + " = " + value);
    }
    return value;
  }
}
