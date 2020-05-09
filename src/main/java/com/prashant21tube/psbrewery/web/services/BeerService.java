package com.prashant21tube.psbrewery.web.services;

import com.prashant21tube.psbrewery.web.model.BeerDto;

import java.util.UUID;

/**
 * Project: ps-brewery
 * Package: com.prashant21tube.psbrewery.web.services
 * <p>
 * User: lenovo
 * Date: 5/10/2020
 * Time: 1:17 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
