package org.rentoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "clothing")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_clothing", discriminatorType = DiscriminatorType.STRING)
public class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ref;

    private String color;
    private String brand;
    private String size;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private RentBusiness rentBusiness;

    @ManyToMany(mappedBy = "clothings")
    private List<RentService> rentService;

}
