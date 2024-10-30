package org.rentoutfits.service;

import org.rentoutfits.dto.request.SuitManDTO;
import org.springframework.http.ResponseEntity;

public interface ISuitMan {

    ResponseEntity<?> save(SuitManDTO suitManDTO);
    ResponseEntity<?> getSuitManBySize(String size);
}
