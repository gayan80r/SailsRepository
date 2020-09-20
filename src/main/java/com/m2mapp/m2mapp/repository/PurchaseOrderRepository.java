package com.m2mapp.m2mapp.repository;

import com.m2mapp.m2mapp.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {
}
