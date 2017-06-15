package com.xie.bean;

import com.xie.annotation.ToString;

public class PersonBean {

  /**
   * name
   */
  @ToString(sortIndex=1)
  private String name;

  /**
   * age
   */
  @ToString(sortIndex=8,ignore=false)
  private String age;

  /**
   * address
   */
  @ToString(sortIndex=3)
  private String add;

  /**
   * career
   */
  @ToString(sortIndex=2)
  private String career;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getAdd() {
    return add;
  }

  public void setAdd(String add) {
    this.add = add;
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }

  public PersonBean(String name, String age, String add, String career) {
    super();
    this.name = name;
    this.age = age;
    this.add = add;
    this.career = career;
  }

  public PersonBean() {}
}
