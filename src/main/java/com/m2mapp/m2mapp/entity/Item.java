package com.m2mapp.m2mapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="number")
    private String number;
    @Column(name="barcode")
    private String barcode;
    @Column(name="sellingPrice")
    private Double sellingPrice;
    @Column(name="buyningPrice")
    private double buyningPrice;

    @OneToMany(mappedBy = "itemobj")
    private List<PurchaseItem> purchaseItemList;
    public Integer getId() {
        return id;
    }

    public List<PurchaseItem> getPurchaseItemList() {
        return purchaseItemList;
    }

    public void setPurchaseItemList(List<PurchaseItem> purchaseItemList) {
        this.purchaseItemList = purchaseItemList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getBuyningPrice() {
        return buyningPrice;
    }

    public void setBuyningPrice(double buyningPrice) {
        this.buyningPrice = buyningPrice;
    }

    public Item() {
        this.id = id;
        this.name = name;
        this.number = number;
        this.barcode = barcode;
        this.sellingPrice = sellingPrice;
        this.buyningPrice = buyningPrice;
    }

    @Override
    public String toString() {
        return name;
    }
}
