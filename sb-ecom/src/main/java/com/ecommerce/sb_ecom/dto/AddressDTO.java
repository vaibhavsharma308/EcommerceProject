package com.ecommerce.sb_ecom.dto;
import lombok.Data;


@Data
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String Country;
    private String zipcode;
}
