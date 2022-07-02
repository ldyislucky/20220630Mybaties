package com.ldy.pojo;

import java.util.List;

/**
 *@author : ldy
 *@version : 1.0
 */
public class Customer {
  private int id;
  private String name;
  private int age;
  private List<Order> orders;

  public Customer() {
  }

  public Customer(int id, String name, int age, List<Order> orders) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", orders=" + orders +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
}
