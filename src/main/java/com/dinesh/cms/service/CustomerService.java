package com.dinesh.cms.service;


import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.data.repository.CustomerRepo;
import com.dinesh.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service("customerService")
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();


    public List<CustomerEntity> getCustomers() {

        return repo.findAll();

    };

    public CustomerEntity addCustomer(CustomerEntity entity){
         repo.save(entity);
         return entity;
    };

    public CustomerEntity getCustomer(int id) {
      return repo.findById(id).get();
    };

    public CustomerEntity upDateCustomer(int id, CustomerEntity entity){
        CustomerEntity foundCustomer = repo.findById(id).get();

        return customerUpdater(foundCustomer, entity);
    }

    public void deleteCustomer(int id){
        repo.deleteById(id);
    }


    public CustomerEntity customerUpdater(CustomerEntity original, CustomerEntity update){
        original.setFirstName(update.getFirstName());
        original.setLastName(update.getLastName());
        original.setEmail(update.getEmail());

        repo.saveAndFlush(original);
        return original;
    };

}
