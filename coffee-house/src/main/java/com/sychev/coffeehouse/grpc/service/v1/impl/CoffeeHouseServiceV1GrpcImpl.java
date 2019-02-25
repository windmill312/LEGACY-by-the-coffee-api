package com.sychev.coffeehouse.grpc.service.v1.impl;

import com.sychev.coffeehouse.model.entity.CafeEntity;
import com.sychev.coffeehouse.model.entity.ProductEntity;
import com.sychev.coffeehouse.service.CoffeeHouseService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sychev.coffeehouse.grpc.service.v1.Service;
import com.sychev.coffeehouse.grpc.model.v1.*;
import com.sychev.coffeehouse.grpc.service.v1.CoffeeHouseServiceV1Grpc;

import java.util.stream.Collectors;

@GRpcService
public class CoffeeHouseServiceV1GrpcImpl extends CoffeeHouseServiceV1Grpc.CoffeeHouseServiceV1ImplBase {

    private final CoffeeHouseService coffeeHouseService;

    @Autowired
    public CoffeeHouseServiceV1GrpcImpl(CoffeeHouseService coffeeHouseService) {
        this.coffeeHouseService = coffeeHouseService;
    }

    @Override
    public void getAllProducts(
            GGetAllProductsRequest request,
            StreamObserver<GGetAllProductsResponse> responseObserver) {

        Page<ProductEntity> questions = coffeeHouseService.getAllProducts(
                ModelConverter.convert(request.getPageable()));

        responseObserver.onNext(GGetAllProductsResponse.newBuilder()
                .setPage(ModelConverter.convert(questions))
                .addAllQuestions(questions.getContent()
                        .stream()
                        .map(ModelConverter::convert)
                        .collect(Collectors.toList()))
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void getAllCafes(
            GGetAllCafesRequest request,
            StreamObserver<GGetAllCafesResponse> responseObserver) {

        List<String> categories = coffeeHouseService.getAllCafes();

        responseObserver.onNext(GGetCategoriesResponse.newBuilder()
                .addAllCategories(categories)
                .build());
        responseObserver.onCompleted();
    }

}
