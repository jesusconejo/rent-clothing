package org.rentoutfits.dto.request;

import lombok.Data;

@Data
public class WomenDressDTO {
    private String color;
    private String brand;
    private String size;
    private Double price;
    private Boolean accessories;
    private int numberPieces;
    private Boolean available;
}
