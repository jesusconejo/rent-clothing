package org.rentoutfits.service.Impl;

import org.rentoutfits.dto.request.SuitManDTO;
import org.rentoutfits.dto.response.SuitManResponseDTO;
import org.rentoutfits.entity.RentService;
import org.rentoutfits.entity.SuitMan;
import org.rentoutfits.repository.SuitManRepository;
import org.rentoutfits.service.ISuitMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuitManService implements ISuitMan {

    private final SuitManRepository suitManRepository;

    @Autowired
    public SuitManService(SuitManRepository suitManRepository) {
        this.suitManRepository = suitManRepository;
    }

    @Override
    public ResponseEntity<?> save(SuitManDTO suitManDTO) {
        SuitMan suitMan = new SuitMan();
        suitMan.setBrand(suitManDTO.getBrand());
        suitMan.setType(suitManDTO.getType());
        suitMan.setColor(suitManDTO.getColor());
        suitMan.setPrice(suitManDTO.getPrice());
        suitMan.setAccessories(suitManDTO.getAccessories());
        suitMan.setSize(suitManDTO.getSize());
        suitMan.setAvailable(true);
        return ResponseEntity.ok(suitManRepository.save(suitMan));
    }

    @Override
    public ResponseEntity<?> getSuitManBySize(String size) {
        List<SuitMan> suitMan = suitManRepository.findBySize(size);
        List<SuitManResponseDTO> suitManResponseDTOs = new ArrayList<>();
        if (!suitMan.isEmpty()) {

            for (SuitMan suitMan1 : suitMan) {
                SuitManResponseDTO suitManResponseDTO = new SuitManResponseDTO();
                suitManResponseDTO.setBrand(suitMan1.getBrand());
                suitManResponseDTO.setColor(suitMan1.getColor());
                suitManResponseDTO.setPrice(suitMan1.getPrice());
                suitManResponseDTO.setSize(suitMan1.getSize());
                suitManResponseDTO.setRef(suitMan1.getRef());
                suitManResponseDTO.setAvailable(suitMan1.getAvailable());
                suitManResponseDTO.setRentServices(getRefs(suitMan1.getRentService()));
                suitManResponseDTO.setType(suitMan1.getType());
                suitManResponseDTO.setAccessories(suitMan1.getAccessories());
                suitManResponseDTOs.add(suitManResponseDTO);
            }
            return ResponseEntity.ok(suitManResponseDTOs);
        }
        return ResponseEntity.notFound().build();
    }

    private static List<Integer> getRefs(List<RentService> rentServicest) {
        return rentServicest.stream()
                .map(RentService::getNumber)
                .collect(Collectors.toList());
    }
}
