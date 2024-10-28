package org.rentoutfits.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class WomenDress extends Clothing{
    private boolean accessories;
    private String size;
    private int numberPieces;
}
