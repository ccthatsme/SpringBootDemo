package com.dinesh.cms.service.mapper;

import com.dinesh.cms.data.entity.ItemEntity;
import com.dinesh.cms.data.entity.OrderEntity;
import com.dinesh.cms.data.repository.ItemRepo;
import com.dinesh.cms.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Optional;

@Component
public class OrderMapper implements EntityModelMapper<OrderEntity, Order> {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Order entityToModel(OrderEntity entity) {
        Assert.notNull(entity,"entity is null");
        Order order = new Order();

        order.setCustomer(customerMapper.entityToModel(entity.getCustomer()));
        order.setDate(entity.getDate());
        order.setItemId(entity.getItem().getId());
        order.setWeightPounds(entity.getWeightPounds());
        order.setOrderId(entity.getId());


        return order;
    }

    @Override
    public OrderEntity modelToEntity(Order model) {
        Assert.notNull(model,"model is null");
        OrderEntity order = new OrderEntity();

        ItemEntity itemEntity = itemRepo.findById(model.getItemId()).get();

        order.setCustomer(customerMapper.modelToEntity(model.getCustomer()));
        order.setDate(model.getDate());
        order.setItem(itemEntity);
        order.setWeightPounds(model.getWeightPounds());
        order.setId(model.getOrderId());

        return order;
    }
}
