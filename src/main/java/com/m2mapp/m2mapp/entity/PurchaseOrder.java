package com.m2mapp.m2mapp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="purchaseorder")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="ponumber")
    private String poNumber;
    @Column(name="podate")
    private Date poDate;
    @Column(name="totalPrice")
    private Double totalPrice;

    @OneToMany(mappedBy = "purchaseorder")
    private List<PurchaseItem> purchaseItemList;

    public List<PurchaseItem> getPurchaseItemList() {
        return purchaseItemList;
    }

    public void setPurchaseItemList(List<PurchaseItem> purchaseItemList) {
        this.purchaseItemList = purchaseItemList;
    }

    public PurchaseOrder() {
        this.id = id;
        this.poNumber = poNumber;
        this.poDate = poDate;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Date getPoDate() {
        return poDate;
    }

    public void setPoDate(Date poDate) {
        this.poDate = poDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return
                poNumber;

    }
}
