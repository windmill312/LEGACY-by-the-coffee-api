package com.sychev.product.repository;

import com.sychev.product.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    Optional<ProductEntity> findByProductUid (UUID productUid);

    void deleteByProductUid (UUID productUid);

    @Query("")
    Optional<ProductEntity> findAllByProductUid;

}
