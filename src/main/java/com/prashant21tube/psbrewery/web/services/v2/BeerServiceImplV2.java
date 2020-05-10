package com.prashant21tube.psbrewery.web.services.v2;

import com.prashant21tube.psbrewery.web.model.v2.BeerDtoV2;
import com.prashant21tube.psbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Project: ps-brewery
 * Package: com.prashant21tube.psbrewery.web.services.v2
 * <p>
 * User: lenovo
 * Date: 5/10/2020
 * Time: 9:40 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
public class BeerServiceImplV2  implements BeerServiceV2{
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.LAGER)
                .build();
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(String beerId, BeerDtoV2 beerDto) {
        //TODO Add proper implementation in Update flow
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting the Beer.....");
    }
}
