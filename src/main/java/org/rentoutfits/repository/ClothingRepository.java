package org.rentoutfits.repository;

import org.rentoutfits.entity.Clothing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClothingRepository extends CrudRepository<Clothing, Integer> {
    Optional<Clothing> findByRef(Integer id);

    List<Clothing> findAllByAvailable(boolean b);
}
