package org.rentoutfits.repository;

import org.rentoutfits.entity.WomenDress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WomenDressRepository extends CrudRepository<WomenDress, Integer> {

    List<WomenDress> findBySize(String size);
}
