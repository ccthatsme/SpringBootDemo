package com.dinesh.cms.service.mapper;

import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.data.entity.ItemEntity;
import com.dinesh.cms.model.Customer;
import com.dinesh.cms.model.Item;
import com.dinesh.cms.model.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ItemMapper implements EntityModelMapper<ItemEntity, Item>{

    @Override
    public Item entityToModel(ItemEntity entity) {
        Assert.notNull(entity,"entity is null");
        Item item = new Item();

        item.setCategory(entity.getCategory());
        item.setId(entity.getId());
        item.setLocation(entity.getLocation());
        item.setName(entity.getName());

        return item;
    }

    @Override
    public ItemEntity modelToEntity(Item model) {
        Assert.notNull(model,"model is null");

        ItemEntity item = new ItemEntity();

        item.setCategory(model.getCategory());
        item.setId(model.getId());
        item.setLocation(model.getLocation());
        item.setName(model.getName());

        return item;
    }
}
