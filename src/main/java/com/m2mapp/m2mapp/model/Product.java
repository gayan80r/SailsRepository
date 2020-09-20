package com.m2mapp.m2mapp.model;

import com.m2mapp.m2mapp.entity.Item;
//model class used to represent the GUI

public class Product {
    private Item  item;
    private Integer quantity;
    private Double lineTotal;

    public Product() {
        this.item = item;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getLineTotal() {
        return item.getSellingPrice()*quantity;
    }

    public void setLineTotal(Double lineTotal) {
        this.lineTotal = item.getSellingPrice()*quantity;;
    }
}
