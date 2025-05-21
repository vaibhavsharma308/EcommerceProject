package com.ecommerce.sb_ecom.mapper;

import com.ecommerce.sb_ecom.dto.AddressDTO;
import com.ecommerce.sb_ecom.dto.UserResponse;
import com.ecommerce.sb_ecom.model.Address;
import com.ecommerce.sb_ecom.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserResponse userToUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setPhone(user.getPhone());
        userResponse.setEmail(user.getEmail());
        AddressDTO addressDTO = addressToDTO(user.getAddress());
        userResponse.setAddress(addressDTO);
        return userResponse;
    }

    public static AddressDTO addressToDTO (Address address){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setZipcode(address.getZipcode());
        return  addressDTO;
    }
}
