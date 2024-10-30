package org.rentoutfits.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("Costume")
public class Costume extends Clothing {
    private boolean hat;
    private int numberPieces;

}
