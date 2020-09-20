package com.m2mapp.m2mapp.service;

import com.m2mapp.m2mapp.entity.PurchaseItem;
import com.m2mapp.m2mapp.entity.PurchaseOrder;
import com.m2mapp.m2mapp.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Override
    public List<PurchaseOrder> findall() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public void save(PurchaseOrder purchaseOrder) {
         purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public void update(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public void delete(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.delete(purchaseOrder);
    }

    @Override
    public PurchaseOrder findById(int id) {
        return purchaseOrderRepository.findById(id).get();
    }
}
