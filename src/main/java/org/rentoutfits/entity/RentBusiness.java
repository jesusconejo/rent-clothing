package org.rentoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "rent_business")
@Data
public class RentBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "rentBusiness")
    private List<Clothing> listClothing;

   @OneToMany
    private List<Clothing> listLaundry;

    @OneToMany(mappedBy = "rentBusiness")
    private List<RentService> rentServices;

    @OneToMany(mappedBy = "rentBusiness")
    private List<Employee> listEmployee;

    @OneToMany(mappedBy = "rentBusiness")
    private List<Client> listClients;
}
