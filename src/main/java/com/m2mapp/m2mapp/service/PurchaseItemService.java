package com.m2mapp.m2mapp.service;

import com.m2mapp.m2mapp.entity.PurchaseItem;

import java.util.List;

public interface PurchaseItemService {
    public List<PurchaseItem> findall();

    public void save (PurchaseItem pItem);
    public void update (PurchaseItem pItem);
    public void delete (PurchaseItem pItem);
    public PurchaseItem findById(int id);
}
