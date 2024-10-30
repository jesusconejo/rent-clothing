package org.rentoutfits.dto.request;


import lombok.Data;

@Data
public class SuitManDTO {
    private String color;
    private String brand;
    private String size;
    private Double price;
    private Boolean available;

    private String type;
    private String accessories;
}
