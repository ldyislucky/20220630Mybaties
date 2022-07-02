package com.ldy.pojo;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Order {
  private int id;
  private int orderNumber;
  private double orderPrice;
  private int customer_id;

    public Order() {
    }

    public Order(int id, int orderNumber, double orderPrice, int customer_id) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", orderPrice=" + orderPrice +
                ", customer_id=" + customer_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
