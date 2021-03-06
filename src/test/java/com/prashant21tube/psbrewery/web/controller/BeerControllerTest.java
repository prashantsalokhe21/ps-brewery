package com.prashant21tube.psbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prashant21tube.psbrewery.web.controller.v2.BeerControllerV2;
import com.prashant21tube.psbrewery.web.model.BeerDto;
import com.prashant21tube.psbrewery.web.services.BeerService;
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
 * Date: 5/10/2020
 * Time: 3:56 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BeerControllerV2.class)
class BeerControllerTest {
    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    @BeforeEach
    void setUp() {
        validBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Beer1")
                //.beerStyle("PALE_ALE")
                .upc(12345689L)
                .build();
    }

    @Test
    void getBeer() throws  Exception{
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer/"+validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void handlePost() throws Exception {
        //given
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
        String beerJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveBeer(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/beer/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(beerJson))
                .andExpect(status().isCreated());

    }

    @Test
    void handleUpdate() throws Exception {
        //given
        BeerDto beerDto = validBeer;
        validBeer.setId(null);
        String beerDtaJSON = objectMapper.writeValueAsString(beerDto);

        //when
        mockMvc.perform(put("/api/v1/beer/"+ UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON)
                .content(beerDtaJSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());

        then(beerService).should().updateBeer(any(), any());
    }
}