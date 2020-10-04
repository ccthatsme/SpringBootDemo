package com.dinesh.cms.data.repository;

import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.data.entity.ItemEntity;
import com.dinesh.cms.data.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Integer>{




List<OrderEntity> findByItem(ItemEntity entity);


    List<OrderEntity> findAllByCustomer(CustomerEntity entity);



}
