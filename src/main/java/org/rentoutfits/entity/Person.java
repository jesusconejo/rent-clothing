package org.rentoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String phone;
}
