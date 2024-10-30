package org.rentoutfits.dto.response;

import lombok.Data;

@Data
public class SuitManResponseDTO extends ClothingResponseDTO {

    private String type;
    private String accessories;
}
