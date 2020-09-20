package com.m2mapp.m2mapp.service;

import com.m2mapp.m2mapp.entity.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findall();

    public void save (Item item);
    public void update (Item item);
    public void delete (Item item);
    public Item findById(int id);
}
