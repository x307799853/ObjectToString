/**
 *
 */
package com.xie.bean;

/**
 * Obj2StringDto.java
 *
 * @author noah
 *
 */
public class Obj2StringDto implements Comparable<Obj2StringDto> {
  /**
   * フィールド名
   */
  private String field;

  /**
   * フィールド値
   */
  private String value;

  /**
   * 表示順番
   */
  private int index;


  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }


  /**
   * 比べる方法
   *
   * @param @param o
   * @param @return
   *
   */
  @Override
  public int compareTo(Obj2StringDto o) {
    return this.index - o.getIndex();
  }

}
