package org.rentoutfits.repository;

import org.rentoutfits.entity.Client;
import org.rentoutfits.entity.RentService;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RentServiceRepository extends CrudRepository<RentService, Integer> {
    List<RentService> findByClient(Optional<Client> client);

    Optional<RentService> findByDateRent(Date dateRent);
}
