package com.sychev.coffeehouse.grpc.service.v1.impl;

import com.sychev.coffeehouse.converter.ModelConverter;
import com.sychev.coffeehouse.grpc.model.v1.GGetAllCafesRequest;
import com.sychev.coffeehouse.grpc.model.v1.GGetAllCafesResponse;
import com.sychev.coffeehouse.grpc.model.v1.GGetCafeRequest;
import com.sychev.coffeehouse.grpc.model.v1.GGetCafeResponse;
import com.sychev.coffeehouse.grpc.service.v1.CoffeeHouseServiceV1Grpc;
import com.sychev.coffeehouse.model.entity.CafeEntity;
import com.sychev.coffeehouse.service.CoffeeHouseService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

@GRpcService
public class CoffeeHouseServiceV1GrpcImpl extends CoffeeHouseServiceV1Grpc.CoffeeHouseServiceV1ImplBase {

    private final CoffeeHouseService coffeeHouseService;

    @Autowired
    public CoffeeHouseServiceV1GrpcImpl(CoffeeHouseService coffeeHouseService) {
        this.coffeeHouseService = coffeeHouseService;
    }

    @Override
    public void getAllCafes(
            GGetAllCafesRequest request,
            StreamObserver<GGetAllCafesResponse> responseObserver) {

        Page<CafeEntity> cafes = coffeeHouseService.getAllCafes(
                ModelConverter.convert(request.getPageable()));

        responseObserver.onNext(GGetAllCafesResponse.newBuilder()
                .setPage(ModelConverter.convert(cafes))
                .addAllCafes(cafes.getContent()
                        .stream()
                        .map(ModelConverter::convert)
                        .collect(Collectors.toList()))
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCafe(
            GGetCafeRequest request,
            StreamObserver<GGetCafeResponse> responseObserver) {

        CafeEntity question = coffeeHouseService.getCafeByUid(ModelConverter.convert(request.getCafeUid()));

        responseObserver.onNext(GGetCafeResponse.newBuilder()
                .setCafe(ModelConverter.convert(question))
                .build());
        responseObserver.onCompleted();
    }

    /*@Override
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
    }*/

}
