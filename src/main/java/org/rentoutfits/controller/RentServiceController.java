package org.rentoutfits.controller;

import org.rentoutfits.dto.request.ClothingLaundryDTO;
import org.rentoutfits.dto.request.RentServiceDTO;
import org.rentoutfits.service.Impl.RentServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rent")
public class RentServiceController {

    private final RentServiceService rentServiceService;

    @Autowired
    public RentServiceController(RentServiceService rentService) {
        this.rentServiceService = rentService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RentServiceDTO rentServiceDTO) {
        return rentServiceService.save(rentServiceDTO);
    }

    @GetMapping("/getServiceById")
    public ResponseEntity<?> getServiceById(@RequestParam("id") Integer id) {
        return rentServiceService.getRentServiceById(id);
    }

    @GetMapping("/getServiceByClient")
    public ResponseEntity<?> getServiceByClient(@RequestParam("clientId") int clientId) {
        return rentServiceService.getRentServiceByClient(clientId);
    }

    @GetMapping("/getServiceByDate")
    public ResponseEntity<?> getServiceByDate(@RequestParam("date") String date) {
        return rentServiceService.getRentServicesByDateRent(date);
    }

    @PostMapping("/doLaundry")
    public ResponseEntity<?> doLaundry(@RequestBody ClothingLaundryDTO clothingLaundryDTO) {
        return rentServiceService.clothingToLaundry(clothingLaundryDTO.getIdClothingLaundry());
    }

    @GetMapping("/listLaundry")
    public ResponseEntity<?> listLaundry() {
        return rentServiceService.getAllClothingByLaundry();
    }
}
