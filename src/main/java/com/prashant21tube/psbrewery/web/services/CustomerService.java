package com.prashant21tube.psbrewery.web.services;

import com.prashant21tube.psbrewery.web.model.CustomerDto;

import java.util.UUID;

/**
 * Project: ps-brewery
 * Package: com.prashant21tube.psbrewery.web.services
 * <p>
 * User: lenovo
 * Date: 5/10/2020
 * Time: 1:53 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomer(UUID customerId);
}
