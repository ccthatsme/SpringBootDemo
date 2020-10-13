package com.dinesh.cms.service;


import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.data.entity.OrderEntity;
import com.dinesh.cms.data.repository.CustomerRepo;
import com.dinesh.cms.data.repository.OrderRepo;
import com.dinesh.cms.model.Customer;
import com.dinesh.cms.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service("customerService")
public class CustomerService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private CustomerMapper customerMapper;

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();


    public List<CustomerEntity> getCustomers() {

        return repo.findAll();

    };

    public List<Customer> getCustomerList(){
        List<Customer> custModel = new ArrayList<>();

        repo.findAll().stream().forEach(entity -> {
            custModel.add(customerMapper.entityToModel(entity));
        });

        return custModel;
    }

    public Customer storeOrUpdate(Customer customer){
        CustomerEntity entity = customerMapper.modelToEntity(customer);

        return customerMapper.entityToModel(repo.save(entity));
    }

    public CustomerEntity addCustomer(CustomerEntity entity){
         repo.save(entity);
         return entity;
    };

    public CustomerEntity getCustomer(int id) {
      return repo.findById(id).get();
    };

    public CustomerEntity upDateCustomer(int id, CustomerEntity entity){

        return customerUpdater(id, entity);
    }

    public void deleteCustomer(int id){
        repo.deleteById(id);
    }


    public CustomerEntity customerUpdater(int id, CustomerEntity update){
        CustomerEntity original = repo.findById(id).get();
        original.setFirstName(update.getFirstName());
        original.setLastName(update.getLastName());
        original.setEmail(update.getEmail());

        repo.saveAndFlush(original);
        return original;
    };

    public List<OrderEntity> getAllOrders(CustomerEntity entity){

        return orderRepo.findAllByCustomer(entity);

    }

}
