package com.dinesh.cms.service;

import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.data.entity.OrderEntity;
import com.dinesh.cms.data.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

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

}
