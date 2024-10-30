package org.rentoutfits.repository;

import org.rentoutfits.entity.SuitMan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SuitManRepository extends CrudRepository<SuitMan, Integer> {
    List<SuitMan> findBySize(String size);
}
