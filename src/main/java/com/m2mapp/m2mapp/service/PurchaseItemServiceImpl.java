package com.m2mapp.m2mapp.service;

import com.m2mapp.m2mapp.entity.PurchaseItem;
import com.m2mapp.m2mapp.repository.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseItemServiceImpl implements PurchaseItemService {
    @Autowired
    private PurchaseItemRepository purchaseItemRepository;
    @Override
    public List<PurchaseItem> findall() {
        return purchaseItemRepository.findAll();
    }

    @Override
    public void save(PurchaseItem pItem) {
purchaseItemRepository.save(pItem);
    }

    @Override
    public void update(PurchaseItem pItem) {
        purchaseItemRepository.save(pItem);
    }

    @Override
    public void delete(PurchaseItem pItem) {
        purchaseItemRepository.delete(pItem);
    }

    @Override
    public PurchaseItem findById(int id) {
        return purchaseItemRepository.findById(id).get();
    }
}
