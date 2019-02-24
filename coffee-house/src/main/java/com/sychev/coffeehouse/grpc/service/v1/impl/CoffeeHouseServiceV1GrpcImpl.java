package com.sychev.coffeehouse.grpc.service.v1.impl;

import com.sychev.coffeehouse.model.entity.CafeEntity;
import com.sychev.coffeehouse.service.CoffeeHouseService;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sychev.coffeehouse.grpc.service.v1.Service;

@GRpcService
public class CoffeeHouseServiceV1GrpcImpl extends CoffeeHouseServiceV1Grpc. {

    private final CoffeeHouseService coffeeHouseService;

    @Autowired
    public CoffeeHouseServiceV1GrpcImpl(CoffeeHouseService coffeeHouseService) {
        this.coffeeHouseService = coffeeHouseService;
    }

    @Override
    public void getAllCafes(Pageable pageable) {

    }

}
