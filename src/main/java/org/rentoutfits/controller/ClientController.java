package org.rentoutfits.controller;

import org.rentoutfits.dto.request.ClientDTO;
import org.rentoutfits.service.Impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveClient(@RequestBody ClientDTO client) {
        return clientService.save(client);
    }
}
