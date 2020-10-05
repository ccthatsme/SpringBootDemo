package com.dinesh.cms.api;

import com.dinesh.cms.data.entity.ItemEntity;
import com.dinesh.cms.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/items")
public class ItemResource {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<ItemEntity> getAllItems(){
       return itemService.getAllItems();
    }

    @PostMapping
    public ItemEntity addItem(@RequestBody ItemEntity itemEntity){
        return itemService.addItem(itemEntity);
    }
}
