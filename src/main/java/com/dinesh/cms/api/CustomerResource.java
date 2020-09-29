package com.dinesh.cms.api;

import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.model.Customer;
import com.dinesh.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    //inject this bean in your resource class
    @Autowired
    private CustomerService service;


    @PostMapping
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer){

        return service.addCustomer(customer);
    };

    @GetMapping
    public List<CustomerEntity> getCustomers(){

        return service.getCustomers();
    }

    @GetMapping(value = "/{id}")
    public CustomerEntity getCustomer(@PathVariable("id") int id){
    return  service.getCustomer(id);
    };

    @PutMapping(value = "/{id}")
    public CustomerEntity updateCustomer(@PathVariable("id") int id, @RequestBody CustomerEntity customer){
        return service.upDateCustomer(id, customer);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteCustomer(@PathVariable int id){
        service.deleteCustomer(id);
        return "Succesfully Deleted";
    }
}
