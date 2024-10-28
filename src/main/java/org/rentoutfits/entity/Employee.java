package org.rentoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Employee extends Person {
    private String role;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private RentBusiness rentBusiness;

    @OneToMany(mappedBy = "employee")
    private List<RentService> rentServices;

}
