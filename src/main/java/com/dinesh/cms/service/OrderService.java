package com.dinesh.cms.service;

import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.data.entity.OrderEntity;
import com.dinesh.cms.data.repository.CustomerRepo;
import com.dinesh.cms.data.repository.ItemRepo;
import com.dinesh.cms.data.repository.OrderRepo;
import com.dinesh.cms.model.Order;
import com.dinesh.cms.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderMapper orderMapper;

    private static final int WEIGHT = 5;

    public List<OrderEntity> getAllOrders(){
        return orderRepo.findAll();
    }

    public List<Order> getOrderModels(){

        List<Order> orderList = new ArrayList<>();

        orderRepo.findAll().stream().forEach(entity -> {
            orderList.add(orderMapper.entityToModel(entity));
        });

        return orderList;
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
