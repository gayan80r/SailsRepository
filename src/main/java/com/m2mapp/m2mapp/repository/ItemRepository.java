package com.m2mapp.m2mapp.repository;

import com.m2mapp.m2mapp.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
