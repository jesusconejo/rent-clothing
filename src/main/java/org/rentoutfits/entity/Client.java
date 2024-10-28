package org.rentoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Client extends Person{
    private String email;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private RentBusiness rentBusiness;

    @OneToMany(mappedBy = "client")
    private List<RentService> rentServices;
}
