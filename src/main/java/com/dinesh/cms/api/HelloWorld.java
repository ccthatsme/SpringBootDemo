package com.dinesh.cms.api;

import com.dinesh.cms.model.Customer;
import com.dinesh.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@ComponentScan(basePackages = "com.dinesh.cms")
public class HelloWorld {

    //map url to this say hello method


    @Autowired
   private CustomerService service;

    @RequestMapping(value = "/hello")
    public String sayHello() {

        return "Hello World!";
    };

    @RequestMapping("/")
    public String homePage(){
        return "Home page";
    }

//    @RequestMapping("/customers")
//    public List<Customer> getAllCustomers(){
//        return service.getCustomers();
//    }
}
