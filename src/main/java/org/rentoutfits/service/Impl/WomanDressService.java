package org.rentoutfits.service.Impl;

import org.rentoutfits.dto.request.WomenDressDTO;
import org.rentoutfits.dto.response.WomenDressResponseDTO;
import org.rentoutfits.entity.RentService;
import org.rentoutfits.entity.WomenDress;
import org.rentoutfits.repository.WomenDressRepository;
import org.rentoutfits.service.IWomenDress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WomanDressService  implements IWomenDress {

    private final WomenDressRepository womenDressRepository;
    @Autowired
    public WomanDressService(WomenDressRepository womenDressRepository) {
        this.womenDressRepository = womenDressRepository;
    }


    @Override
    public ResponseEntity<?> saveWomenDress(WomenDressDTO womenDressDTO) {
        WomenDress womenDress = new WomenDress();
        womenDress.setAccessories(womenDressDTO.getAccessories());
        womenDress.setNumberPieces(womenDressDTO.getNumberPieces());
        womenDress.setPrice(womenDressDTO.getPrice());
        womenDress.setColor(womenDressDTO.getColor());
        womenDress.setBrand(womenDressDTO.getBrand());
        womenDress.setSize(womenDressDTO.getSize());
        womenDress.setAvailable(true);

        return ResponseEntity.ok(womenDressRepository.save(womenDress));
    }

    @Override
    public ResponseEntity<?> getWomenDressBySize(String size) {
        List<WomenDressResponseDTO> responseDTOs = new ArrayList<>();
        List<WomenDress> womenDress = womenDressRepository.findBySize(size);
        for (WomenDress womenDressDTO : womenDress) {
            WomenDressResponseDTO responseDTO = new WomenDressResponseDTO();
            responseDTO.setRef(womenDressDTO.getRef());
            responseDTO.setPrice(womenDressDTO.getPrice());
            responseDTO.setColor(womenDressDTO.getColor());
            responseDTO.setBrand(womenDressDTO.getBrand());
            responseDTO.setSize(womenDressDTO.getSize());
            responseDTO.setAvailable(womenDressDTO.getAvailable());
            responseDTO.setAccessories(womenDressDTO.getAccessories());
            responseDTO.setRentServices(getRefs(womenDressDTO.getRentService()));
            responseDTOs.add(responseDTO);
        }

        return ResponseEntity.ok(responseDTOs);
    }

    private static List<Integer> getRefs(List<RentService> rentServicest) {
        return rentServicest.stream()
                .map(RentService::getNumber)
                .collect(Collectors.toList());
    }
}
