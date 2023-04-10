package com.preproject.UserPizzaService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {
    @Id
    private String userName;
    private String password;
    private List<Order> orderList;
    private List<Pizza> cartList;

    public User() {
    }

    public User(String userName, String password, List<Order> orderList, List<Pizza> cartList) {
        this.userName = userName;
        this.password = password;
        this.orderList = orderList;
        this.cartList = cartList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Pizza> getCartList() {
        return cartList;
    }

    public void setCartList(List<Pizza> cartList) {
        this.cartList = cartList;
    }

}
