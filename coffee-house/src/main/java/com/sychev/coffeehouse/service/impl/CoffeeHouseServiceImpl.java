package com.sychev.coffeehouse.service.impl;

import com.sychev.coffeehouse.exception.NotFoundCafeException;
import com.sychev.coffeehouse.model.entity.CafeEntity;
import com.sychev.coffeehouse.repository.CafeRepository;
import com.sychev.coffeehouse.service.CoffeeHouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CoffeeHouseServiceImpl implements CoffeeHouseService {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeHouseServiceImpl.class);

    private final CafeRepository cafeRepository;
    //private final ProductRepository productRepository;

    public CoffeeHouseServiceImpl(
            CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
        //this.productRepository = productRepository;
    }

    //todo проверить диапазон широт и высот
    @Override
    public Page<CafeEntity> getAllCafesAroundClient(Pageable pageable, Double latitude, Double longitude) {
        return cafeRepository.findByLatitudeBetweenAndLongitudeBetween(
                pageable,
                latitude - 20,
                latitude + 20,
                longitude - 20,
                latitude + 20);
    }

    @Override
    public CafeEntity getCafeByUid(UUID cafeUid) {
        return cafeRepository.findByUidCafe(cafeUid).orElseThrow(() -> {
            logger.info("Not found cafe with uid={}", cafeUid);
            return new NotFoundCafeException("Not found cafe with uid=" + cafeUid);
        });
    }

    @Override
    public UUID addCafe(CafeEntity entity) {
        logger.debug("Add new cafe with name={}", entity.getName());
        return cafeRepository.save(entity).getUidCafe();
    }

    @Override
    public void updateCafe(CafeEntity entity) {
        CafeEntity cafe = cafeRepository.findByUidCafe(entity.getUidCafe()).orElseThrow(() -> {
            logger.info("Not found cafe with uid={}", entity.getUidCafe());
            return new NotFoundCafeException("Not found cafe with uid=" + entity.getUidCafe());
        });
        logger.debug("Update cafe with name={}", entity.getName());
        cafeRepository.save(cafe.copy(entity));
    }

    @Override
    @Transactional
    public void removeCafe(UUID cafeUid) {
        cafeRepository.deleteByUidCafe(cafeUid);
    }

    /*
    /*@Override
    public Page<ProductEntity> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<ProductEntity> getProductsByCafe(UUID cafeUid, Pageable pageable) {
        CafeEntity cafe = cafeRepository.findByUidCafe(cafeUid).orElseThrow(() -> {
            logger.info("Not found cafe with uid={}", cafeUid);
            return new NotFoundCafeException("Not found cafe with uid=" + cafeUid);
        });
        return productRepository.findByCafe(cafe, pageable);
    }

    @Override
    public ProductEntity getProductByUid(UUID productUid) {
        return productRepository.findByUidProduct(productUid)
                .orElseThrow(() -> {
                    logger.info("Not found product with uid={}", productUid);
                    return new NotFoundProductException("Not found product with uid=" + productUid);
                });
    }

    @Override
    public UUID addProduct(ProductEntity entity) {
        logger.debug("Add new product with name={} for cafe={}", entity.getName(), entity.getCafe().getName());
        return productRepository.save(entity).getUidProduct();
    }

    @Override
    @Transactional
    public void removeProduct(UUID productUid, UUID cafeUid) {
        CafeEntity cafe = cafeRepository.findByUidCafe(cafeUid).orElseThrow(() -> {
            logger.info("Not found cafe with uid={}", cafeUid);
            return new NotFoundCafeException("Not found cafe with uid=" + cafeUid);
        });
        ProductEntity product = productRepository.findByUidProduct(productUid).orElseThrow(() -> {
            logger.info("Not found product with uid={}", productUid);
            return new NotFoundProductException("Not found product with uid=" + productUid);
        });
        Set<ProductEntity> products = cafe.getProducts();
        products.remove(product);
        cafe.setProducts(products);
        cafeRepository.save(cafe);
    }*/
}
