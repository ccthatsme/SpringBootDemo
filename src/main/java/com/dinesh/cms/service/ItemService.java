package com.dinesh.cms.service;

import com.dinesh.cms.data.entity.ItemEntity;
import com.dinesh.cms.data.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    public List<ItemEntity> getAllItems(){
       return itemRepo.findAll();
    };

    public ItemEntity getSpecificItem(int id){
        return itemRepo.findById(id).get();
    }

    public ItemEntity addItem(ItemEntity entity){
        return itemRepo.save(entity);
    }
}
