package com.ecommerce.sb_ecom.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="address_table")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String Country;
    private String zipcode;
}
