package com.prashant21tube.psbrewery.web.services;

import com.prashant21tube.psbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Project: ps-brewery
 * Package: com.prashant21tube.psbrewery.web.services
 * <p>
 * User: lenovo
 * Date: 5/10/2020
 * Time: 1:20 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pele Ale")
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(String beerId, BeerDto beerDto) {
        //TODO Add proper implementation in Update flow
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting the Beer.....");
    }
}
