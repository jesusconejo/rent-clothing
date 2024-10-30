package org.rentoutfits.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ClothingResponseDTO {
    private int ref;
    private String color;
    private String brand;
    private String size;
    private Double price;
    private Boolean available;
    private List<Integer> rentServices;
}
