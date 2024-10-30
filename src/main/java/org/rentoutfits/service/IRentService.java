package org.rentoutfits.service;

import org.rentoutfits.dto.request.RentServiceDTO;
import org.springframework.http.ResponseEntity;

public interface IRentService {
    ResponseEntity<?> save(RentServiceDTO rent);
    ResponseEntity<?> getRentServiceById(int rentServiceId);
    ResponseEntity<?> getRentServiceByClient(int clientId);
    ResponseEntity<?> getAllRentServices();
    ResponseEntity<?> getRentServicesByDateRent(String dateRent);
    ResponseEntity<?> clothingToLaundry(int clothingId);
    ResponseEntity<?> getAllClothingByLaundry();
}
