package com.m2mapp.m2mapp.entity;

import javax.persistence.*;

@Entity
@Table(name="purchaseitem")
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="item_id")
     private  Item itemobj;

    public Item getItemobj() {
        return itemobj;
    }

    public void setItemobj(Item itemobj) {
        this.itemobj = itemobj;
    }

    public PurchaseOrder getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(PurchaseOrder purchaseorder) {
        this.purchaseorder = purchaseorder;
    }

    @ManyToOne
 @JoinColumn(name="poder_id")
  private PurchaseOrder purchaseorder;

    public PurchaseItem() {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
