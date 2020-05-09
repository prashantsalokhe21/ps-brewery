package com.prashant21tube.psbrewery.web.services;

import com.prashant21tube.psbrewery.web.model.BeerDto;
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
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pele Ale")
                .build();
    }
}
