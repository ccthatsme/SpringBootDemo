package com.dinesh.cms.data.repository;

import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.data.entity.OrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {


}
