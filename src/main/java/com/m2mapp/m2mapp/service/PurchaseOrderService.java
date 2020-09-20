package com.m2mapp.m2mapp.service;

import com.m2mapp.m2mapp.entity.PurchaseItem;
import com.m2mapp.m2mapp.entity.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {
    public List<PurchaseOrder> findall();

    public void save (PurchaseOrder purchaseOrder);
    public void update (PurchaseOrder purchaseOrder);
    public void delete (PurchaseOrder purchaseOrder);
    public PurchaseOrder findById(int id);
}
