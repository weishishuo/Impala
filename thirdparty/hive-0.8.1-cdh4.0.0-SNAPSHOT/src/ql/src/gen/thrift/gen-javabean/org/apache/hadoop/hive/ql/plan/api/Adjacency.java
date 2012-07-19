/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.apache.hadoop.hive.ql.plan.api;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Adjacency implements org.apache.thrift.TBase<Adjacency, Adjacency._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Adjacency");

  private static final org.apache.thrift.protocol.TField NODE_FIELD_DESC = new org.apache.thrift.protocol.TField("node", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CHILDREN_FIELD_DESC = new org.apache.thrift.protocol.TField("children", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField ADJACENCY_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("adjacencyType", org.apache.thrift.protocol.TType.I32, (short)3);

  private String node; // required
  private List<String> children; // required
  private AdjacencyType adjacencyType; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NODE((short)1, "node"),
    CHILDREN((short)2, "children"),
    /**
     * 
     * @see AdjacencyType
     */
    ADJACENCY_TYPE((short)3, "adjacencyType");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NODE
          return NODE;
        case 2: // CHILDREN
          return CHILDREN;
        case 3: // ADJACENCY_TYPE
          return ADJACENCY_TYPE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NODE, new org.apache.thrift.meta_data.FieldMetaData("node", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CHILDREN, new org.apache.thrift.meta_data.FieldMetaData("children", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.ADJACENCY_TYPE, new org.apache.thrift.meta_data.FieldMetaData("adjacencyType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, AdjacencyType.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Adjacency.class, metaDataMap);
  }

  public Adjacency() {
  }

  public Adjacency(
    String node,
    List<String> children,
    AdjacencyType adjacencyType)
  {
    this();
    this.node = node;
    this.children = children;
    this.adjacencyType = adjacencyType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Adjacency(Adjacency other) {
    if (other.isSetNode()) {
      this.node = other.node;
    }
    if (other.isSetChildren()) {
      List<String> __this__children = new ArrayList<String>();
      for (String other_element : other.children) {
        __this__children.add(other_element);
      }
      this.children = __this__children;
    }
    if (other.isSetAdjacencyType()) {
      this.adjacencyType = other.adjacencyType;
    }
  }

  public Adjacency deepCopy() {
    return new Adjacency(this);
  }

  @Override
  public void clear() {
    this.node = null;
    this.children = null;
    this.adjacencyType = null;
  }

  public String getNode() {
    return this.node;
  }

  public void setNode(String node) {
    this.node = node;
  }

  public void unsetNode() {
    this.node = null;
  }

  /** Returns true if field node is set (has been assigned a value) and false otherwise */
  public boolean isSetNode() {
    return this.node != null;
  }

  public void setNodeIsSet(boolean value) {
    if (!value) {
      this.node = null;
    }
  }

  public int getChildrenSize() {
    return (this.children == null) ? 0 : this.children.size();
  }

  public java.util.Iterator<String> getChildrenIterator() {
    return (this.children == null) ? null : this.children.iterator();
  }

  public void addToChildren(String elem) {
    if (this.children == null) {
      this.children = new ArrayList<String>();
    }
    this.children.add(elem);
  }

  public List<String> getChildren() {
    return this.children;
  }

  public void setChildren(List<String> children) {
    this.children = children;
  }

  public void unsetChildren() {
    this.children = null;
  }

  /** Returns true if field children is set (has been assigned a value) and false otherwise */
  public boolean isSetChildren() {
    return this.children != null;
  }

  public void setChildrenIsSet(boolean value) {
    if (!value) {
      this.children = null;
    }
  }

  /**
   * 
   * @see AdjacencyType
   */
  public AdjacencyType getAdjacencyType() {
    return this.adjacencyType;
  }

  /**
   * 
   * @see AdjacencyType
   */
  public void setAdjacencyType(AdjacencyType adjacencyType) {
    this.adjacencyType = adjacencyType;
  }

  public void unsetAdjacencyType() {
    this.adjacencyType = null;
  }

  /** Returns true if field adjacencyType is set (has been assigned a value) and false otherwise */
  public boolean isSetAdjacencyType() {
    return this.adjacencyType != null;
  }

  public void setAdjacencyTypeIsSet(boolean value) {
    if (!value) {
      this.adjacencyType = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NODE:
      if (value == null) {
        unsetNode();
      } else {
        setNode((String)value);
      }
      break;

    case CHILDREN:
      if (value == null) {
        unsetChildren();
      } else {
        setChildren((List<String>)value);
      }
      break;

    case ADJACENCY_TYPE:
      if (value == null) {
        unsetAdjacencyType();
      } else {
        setAdjacencyType((AdjacencyType)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NODE:
      return getNode();

    case CHILDREN:
      return getChildren();

    case ADJACENCY_TYPE:
      return getAdjacencyType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NODE:
      return isSetNode();
    case CHILDREN:
      return isSetChildren();
    case ADJACENCY_TYPE:
      return isSetAdjacencyType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Adjacency)
      return this.equals((Adjacency)that);
    return false;
  }

  public boolean equals(Adjacency that) {
    if (that == null)
      return false;

    boolean this_present_node = true && this.isSetNode();
    boolean that_present_node = true && that.isSetNode();
    if (this_present_node || that_present_node) {
      if (!(this_present_node && that_present_node))
        return false;
      if (!this.node.equals(that.node))
        return false;
    }

    boolean this_present_children = true && this.isSetChildren();
    boolean that_present_children = true && that.isSetChildren();
    if (this_present_children || that_present_children) {
      if (!(this_present_children && that_present_children))
        return false;
      if (!this.children.equals(that.children))
        return false;
    }

    boolean this_present_adjacencyType = true && this.isSetAdjacencyType();
    boolean that_present_adjacencyType = true && that.isSetAdjacencyType();
    if (this_present_adjacencyType || that_present_adjacencyType) {
      if (!(this_present_adjacencyType && that_present_adjacencyType))
        return false;
      if (!this.adjacencyType.equals(that.adjacencyType))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Adjacency other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Adjacency typedOther = (Adjacency)other;

    lastComparison = Boolean.valueOf(isSetNode()).compareTo(typedOther.isSetNode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.node, typedOther.node);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChildren()).compareTo(typedOther.isSetChildren());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChildren()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.children, typedOther.children);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAdjacencyType()).compareTo(typedOther.isSetAdjacencyType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAdjacencyType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.adjacencyType, typedOther.adjacencyType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // NODE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.node = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // CHILDREN
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
              this.children = new ArrayList<String>(_list0.size);
              for (int _i1 = 0; _i1 < _list0.size; ++_i1)
              {
                String _elem2; // required
                _elem2 = iprot.readString();
                this.children.add(_elem2);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // ADJACENCY_TYPE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.adjacencyType = AdjacencyType.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.node != null) {
      oprot.writeFieldBegin(NODE_FIELD_DESC);
      oprot.writeString(this.node);
      oprot.writeFieldEnd();
    }
    if (this.children != null) {
      oprot.writeFieldBegin(CHILDREN_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, this.children.size()));
        for (String _iter3 : this.children)
        {
          oprot.writeString(_iter3);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.adjacencyType != null) {
      oprot.writeFieldBegin(ADJACENCY_TYPE_FIELD_DESC);
      oprot.writeI32(this.adjacencyType.getValue());
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Adjacency(");
    boolean first = true;

    sb.append("node:");
    if (this.node == null) {
      sb.append("null");
    } else {
      sb.append(this.node);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("children:");
    if (this.children == null) {
      sb.append("null");
    } else {
      sb.append(this.children);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("adjacencyType:");
    if (this.adjacencyType == null) {
      sb.append("null");
    } else {
      sb.append(this.adjacencyType);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}
