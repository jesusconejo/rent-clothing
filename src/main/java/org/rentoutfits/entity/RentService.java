package org.rentoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rent_service")
@Data
public class RentService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Temporal(TemporalType.DATE)
    private Date dateRequest;

    @Temporal(TemporalType.DATE)
    private Date dateRent;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private RentBusiness rentBusiness;

    @ManyToMany
    @JoinTable(
            name = "rent_clothings",
            joinColumns = @JoinColumn(name = "rent_service_id"),
            inverseJoinColumns = @JoinColumn(name = "clothings_ref")
    )
    private List<Clothing> clothings;

}
