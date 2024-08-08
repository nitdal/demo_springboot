package com.niteshdalmia.simpleWebApp.model;

import org.springframework.stereotype.Component;


@Component
public class Product {

    public int prodId;
    public String prodName;
    public int price;

    public Product(){
    }

    public Product(int prodId, String prodName,  int price) {
        this.prodName = prodName;
        this.prodId = prodId;
        this.price = price;
    }

    public int getProdId() {
        return this.prodId;
    }

    public String getProdName() {
        return this.prodName;
    }

    public int getPrice() {
        return this.price;
    }
}
