package com.example.myapplication;

public class ItemObject {

    private String userName;
    private double price;

    public ItemObject(String m_userName, double m_price){
        this.userName = m_userName;
        this.price = m_price;
    }

    public String getUserName() {
        return userName;
    }

    public double getPrice() {
        return price;
    }
}
