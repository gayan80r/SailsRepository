package com.m2mapp.m2mapp.service;

import com.m2mapp.m2mapp.entity.Item;
import com.m2mapp.m2mapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findall() {
        //return null;
        return itemRepository.findAll();
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void update(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void delete(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public Item findById(int id) {
        return itemRepository.findById(id).get();
    }
}
