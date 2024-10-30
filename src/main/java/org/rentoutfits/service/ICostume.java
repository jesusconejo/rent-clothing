package org.rentoutfits.service;

import org.rentoutfits.dto.request.CostumeDTO;
import org.rentoutfits.entity.Costume;
import org.springframework.http.ResponseEntity;

public interface ICostume {
    ResponseEntity<?> save(CostumeDTO costume);
}
