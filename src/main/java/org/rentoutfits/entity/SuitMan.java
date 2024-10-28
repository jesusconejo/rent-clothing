package org.rentoutfits.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class SuitMan extends Clothing{
    private String type;
    private String accessories;
}
