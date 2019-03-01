package com.sychev.coffeehouse.service;

import com.sychev.coffeehouse.model.entity.CafeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CoffeeHouseService {

    Page<CafeEntity> getAllCafesAroundClient(Pageable pageable, Double latitude, Double longitude);

    CafeEntity getCafeByUid(UUID cafeUid);

    UUID addCafe(CafeEntity entity);

    void updateCafe(CafeEntity entity);

    void removeCafe(UUID cafeUid);

    //UUID addProduct(ProductEntity entity);

    //Page<ProductEntity> getAllProducts(Pageable pageable);

    //Page<ProductEntity> getProductsByCafe(UUID cafeUid, Pageable pageable);

    //ProductEntity getProductByUid(UUID productUid);

    //void removeProduct(UUID productUid, UUID cafeUid);

}
