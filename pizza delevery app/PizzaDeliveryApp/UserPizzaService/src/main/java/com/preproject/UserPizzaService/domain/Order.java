package com.preproject.UserPizzaService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Order {
    @Id
    private int orderId;
    private Date orderDate;
    private List<Pizza> orderItems;
    private double totalOrderPrice;

    public Order() {
    }

    public Order(int orderId, Date orderDate, List<Pizza> orderItems, double totalOrderPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.totalOrderPrice = totalOrderPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Pizza> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Pizza> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", orderItems=" + orderItems +
                ", totalOrderPrice=" + totalOrderPrice +
                '}';
    }
}
