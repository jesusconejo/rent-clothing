package org.rentoutfits.service;

import org.rentoutfits.dto.request.WomenDressDTO;
import org.rentoutfits.entity.WomenDress;
import org.springframework.http.ResponseEntity;

public interface IWomenDress {

    ResponseEntity<?> saveWomenDress(WomenDressDTO womenDressDTO);
    ResponseEntity<?> getWomenDressBySize(String size);
}
