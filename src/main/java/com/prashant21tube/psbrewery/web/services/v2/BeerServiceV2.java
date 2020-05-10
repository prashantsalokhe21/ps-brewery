package com.prashant21tube.psbrewery.web.services.v2;

import com.prashant21tube.psbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

/**
 * Project: ps-brewery
 * Package: com.prashant21tube.psbrewery.web.services.v2
 * <p>
 * User: lenovo
 * Date: 5/10/2020
 * Time: 9:37 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveBeer(BeerDtoV2 beerDto);

    void updateBeer(String beerId, BeerDtoV2 beerDto);

    void deleteBeerById(UUID beerId);
}
