package com.ctrip.framework.apollo.common.dto;


public class ItemDTO extends BaseDTO{

  private long id;

  private long namespaceId;

  /**
   * 对于 properties ，使用 Item 的 key ，对应每条配置项的键。
   * 对于 yaml 等等，使用 Item 的 key = content ，对应整个配置文件。
   */
  private String key;

  private String value;

  private String comment;

  /**
   * 行号。主要用于 properties 类型的配置文件。
   */
  private int lineNum;

  public ItemDTO() {

  }

  public ItemDTO(String key, String value, String comment, int lineNum) {
    this.key = key;
    this.value = value;
    this.comment = comment;
    this.lineNum = lineNum;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public String getKey() {
    return key;
  }

  public long getNamespaceId() {
    return namespaceId;
  }

  public String getValue() {
    return value;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setNamespaceId(long namespaceId) {
    this.namespaceId = namespaceId;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public int getLineNum() {
    return lineNum;
  }

  public void setLineNum(int lineNum) {
    this.lineNum = lineNum;
  }

}
