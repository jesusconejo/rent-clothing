package org.rentoutfits.dto.request;

import lombok.Data;

@Data
public class CostumeDTO {
    private String color;
    private String brand;
    private String size;
    private Double price;
    private boolean hat;
    private int numberPieces;
}
