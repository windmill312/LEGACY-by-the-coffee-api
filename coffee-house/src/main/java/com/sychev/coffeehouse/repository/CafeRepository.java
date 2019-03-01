package com.sychev.coffeehouse.repository;

import com.sychev.coffeehouse.model.entity.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CafeRepository extends JpaRepository<CafeEntity, Integer> {

    Optional<CafeEntity> findByName(String name);

    Optional<CafeEntity> findByUidCafe(UUID cafeUid);

    void deleteByUidCafe(UUID cafeUid);

    Optional<List<CafeEntity>> findByLatitudeBetweenAndLongitudeBetween(Double fromLatitude,
                                                                        Double tillLatitude,
                                                                        Double fromLongitude,
                                                                        Double tillLongitude);
}
