package org.rentoutfits.dto.request;

import lombok.Data;
import org.rentoutfits.entity.Clothing;

import java.util.Date;
import java.util.List;

@Data
public class RentServiceDTO {

    private Date dateRequest;
    private String dateRent;
    private int clientId;
    private Long employeeId;

    private List<Integer> clothingList;
    private int quantity;
}
