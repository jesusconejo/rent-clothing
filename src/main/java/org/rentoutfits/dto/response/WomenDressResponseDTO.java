package org.rentoutfits.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class WomenDressResponseDTO extends ClothingResponseDTO {

    private Boolean accessories;
    private  int numberPieces;
}
