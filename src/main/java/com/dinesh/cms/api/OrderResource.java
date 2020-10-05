package com.dinesh.cms.api;

import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.data.entity.OrderEntity;
import com.dinesh.cms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public List<OrderEntity> getAllOrders(){
        return service.getAllOrders();
    }

    @GetMapping(value = "/{id}")
    public OrderEntity getOrder(@PathVariable int id){
        return service.getSpecificOrder(id);
    }

    @PostMapping
    public OrderEntity addOrder(@RequestParam int itemId, @RequestBody CustomerEntity entity){
        return service.addOrder(itemId, entity);
    }
}
