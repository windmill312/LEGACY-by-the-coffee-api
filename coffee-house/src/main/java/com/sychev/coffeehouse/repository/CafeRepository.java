package com.sychev.coffeehouse.repository;

import com.sychev.coffeehouse.model.entity.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CafeRepository extends JpaRepository<CafeEntity, Integer> {

    Optional<CafeEntity> findByName(String name);

    Optional<CafeEntity> findByUidCafe(UUID cafeUid);

    void deleteByUidCafe(UUID cafeUid);

    //todo поиск по локации (+- какое то расстояние от клиента)
    //Optional<CafeEntity> findByLocationBetween(Pair<Double,Double> pair1, Pair<Double,Double> pair2);
}
