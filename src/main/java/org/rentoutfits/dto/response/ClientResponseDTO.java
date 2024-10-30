package org.rentoutfits.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ClientResponseDTO {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private List<Integer> rentService;
}
