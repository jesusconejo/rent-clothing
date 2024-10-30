package org.rentoutfits.service.Impl;

import org.rentoutfits.dto.request.CostumeDTO;
import org.rentoutfits.repository.CostumeRepository;
import org.rentoutfits.service.ICostume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CostumeService implements ICostume {
    private final CostumeRepository costumeRepository;

    @Autowired
    public CostumeService(CostumeRepository costumeRepository) {
        this.costumeRepository = costumeRepository;
    }

    @Override
    public ResponseEntity<?> save(CostumeDTO costume) {
        return null;
    }
}
