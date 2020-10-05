package com.dinesh.cms.service;

import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.data.entity.OrderEntity;
import com.dinesh.cms.data.repository.CustomerRepo;
import com.dinesh.cms.data.repository.ItemRepo;
import com.dinesh.cms.data.repository.OrderRepo;
import com.dinesh.cms.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CustomerRepo customerRepo;

    private static final int WEIGHT = 5;

    public List<OrderEntity> getAllOrders(){
        return orderRepo.findAll();
    }

    public OrderEntity getSpecificOrder(int id){
        return orderRepo.findById(id).get();
    }

    public void deleteOrder(int id){
         orderRepo.deleteById(id);
    }

    public OrderEntity updateOrder(int id, OrderEntity entity ){
        return orderRepo.save(entity);
    }

    public OrderEntity orderUpdater(int id, OrderEntity update){
        OrderEntity original = orderRepo.findById(id).get();


        orderRepo.saveAndFlush(original);
        return original;
    };

    public OrderEntity addOrder(int itemId, CustomerEntity entity) {
        Date date = new Date(System.currentTimeMillis());
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setDate(date);
        orderEntity.setWeightPounds(WEIGHT);
        orderEntity.setCustomer(customerRepo.findById(entity.getId()).get());
        orderEntity.setItem(itemRepo.findById(itemId).get());

        return orderRepo.saveAndFlush(orderEntity);
    }


}
