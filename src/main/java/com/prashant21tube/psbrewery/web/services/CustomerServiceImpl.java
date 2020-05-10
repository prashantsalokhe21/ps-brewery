package com.prashant21tube.psbrewery.web.services;

import com.prashant21tube.psbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Project: ps-brewery
 * Package: com.prashant21tube.psbrewery.web.services
 * <p>
 * User: lenovo
 * Date: 5/10/2020
 * Time: 1:54 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Prashant Salokhe")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Updating the customer.....");
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting the customer.....");
    }
}
