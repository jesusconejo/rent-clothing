package org.rentoutfits.repository;

import org.rentoutfits.entity.Client;
import org.rentoutfits.entity.SuitMan;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    interface SuitManRespository extends CrudRepository<SuitMan, Integer> {
    }
}
