package com.dinesh.cms.service.mapper;

import com.dinesh.cms.data.entity.CustomerEntity;
import com.dinesh.cms.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CustomerMapper implements EntityModelMapper<CustomerEntity, Customer>{



    @Override
    public Customer entityToModel(CustomerEntity entity) {
        Assert.notNull(entity,"entity is null");
        Customer customer = new Customer();

        customer.setCustomerId(entity.getId());
        customer.setFirstName(entity.getFirstName());
        customer.setLastName(entity.getLastName());
        customer.setEmail(entity.getEmail());

        return customer;
    }

    @Override
    public CustomerEntity modelToEntity(Customer model) {
        Assert.notNull(model,"model is null");
        CustomerEntity customer = new CustomerEntity();

        customer.setId(model.getCustomerId());
        customer.setFirstName(model.getFirstName());
        customer.setLastName(model.getLastName());
        customer.setEmail(model.getEmail());

        return customer;
    }
}
