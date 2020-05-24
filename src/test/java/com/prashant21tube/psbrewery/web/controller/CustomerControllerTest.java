package com.prashant21tube.psbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prashant21tube.psbrewery.web.model.CustomerDto;
import com.prashant21tube.psbrewery.web.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Project: ps-brewery
 * Package: com.prashant21tube.psbrewery.web.controller
 * <p>
 * User: lenovo
 * Date: 5/24/2020
 * Time: 11:28 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @MockBean
    CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CustomerDto customer;

    @BeforeEach
    void setUp() {
        customer = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Prashant Salokhe")
                .build();
    }
    @Test
    void getCustomer() throws Exception {
        given(customerService.getCustomerById(any(UUID.class))).willReturn(customer);

        mockMvc.perform(get("/api/v1/customer/"+customer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createCustomer() throws Exception {
        //given
        CustomerDto customerDto = customer;
        customerDto.setId(null);
        CustomerDto savedDto = CustomerDto.builder().id(UUID.randomUUID()).name("Kunal Patil").build();
        String customerJson = objectMapper.writeValueAsString(customerDto);

        given(customerService.saveCustomer(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/customer/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(customerJson))
                .andExpect(status().isCreated());
    }

    @Test
    void handleUpdate() throws Exception{
        //given
        CustomerDto customerDto = customer;
        customerDto.setId(null);
        String customerDtoJSON = objectMapper.writeValueAsString(customerDto);

        //when
        mockMvc.perform(put("/api/v1/customer/"+ UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON)
                .content(customerDtoJSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());

        then(customerService).should().updateCustomer(any(), any());
    }

    @Test
    void handleDelete() {
    }
}