package com.preproject.UserPizzaService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pizza {
    @Id
    private int pizzaId;
    private String pizzaName;
    private double price;
    private String size;
    private int quantity;


    public Pizza() {
    }

    public Pizza(int pizzaId, String pizzaName, double price, int quantity,String size) {
        this.pizzaId = pizzaId;
        this.pizzaName = pizzaName;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaId=" + pizzaId +
                ", pizzaName='" + pizzaName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", size='" + size + '\'' +
                '}';
    }
}
