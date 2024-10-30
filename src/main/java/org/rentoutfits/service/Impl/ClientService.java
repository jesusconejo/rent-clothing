package org.rentoutfits.service.Impl;

import org.rentoutfits.dto.request.ClientDTO;
import org.rentoutfits.dto.response.ClientResponseDTO;
import org.rentoutfits.entity.Client;
import org.rentoutfits.repository.ClientRepository;
import org.rentoutfits.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClient {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ResponseEntity<?> save(ClientDTO client) {
        ClientResponseDTO responseDTO = new ClientResponseDTO();
        Client newClient = new Client();
        newClient.setName(client.getName());
        newClient.setAddress(client.getAddress());
        newClient.setPhone(client.getPhone());
        newClient.setEmail(client.getEmail());
        clientRepository.save(newClient);
        return ResponseEntity.ok(newClient);

    }

    @Override
    public ResponseEntity<?> delete(ClientDTO client) {
        return null;
    }
}
