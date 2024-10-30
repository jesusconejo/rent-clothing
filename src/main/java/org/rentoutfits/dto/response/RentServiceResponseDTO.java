package org.rentoutfits.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class RentServiceResponseDTO {
    private int id;
    private String dateRequest;
    private String dateRent;
    private int clientId;
    private int employeeId;

    private List<Integer> clothingList;

}
