package org.rentoutfits.service;

import org.rentoutfits.dto.request.ClientDTO;
import org.springframework.http.ResponseEntity;

public interface IClient {
    ResponseEntity<?> save(ClientDTO client);
    ResponseEntity<?> delete(ClientDTO client);
}
