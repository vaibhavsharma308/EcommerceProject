package com.ecommerce.sb_ecom.service;


import com.ecommerce.sb_ecom.dto.UserResponse;
import com.ecommerce.sb_ecom.mapper.UserMapper;
import com.ecommerce.sb_ecom.model.Address;
import com.ecommerce.sb_ecom.model.User;
import com.ecommerce.sb_ecom.model.UserRole;
import com.ecommerce.sb_ecom.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    public static User createMockUser() {
        Address mockAddress = new Address();
        mockAddress.setId(1L);
        mockAddress.setStreet("123 Main St");
        mockAddress.setCity("New York");
        mockAddress.setState("NY");
        mockAddress.setZipcode("10001");


        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setFirstName("John");
        mockUser.setLastName("Doe");
        mockUser.setEmail("john.doe@example.com");
        mockUser.setPhone("1234567890");
        mockUser.setRole(UserRole.CUSTOMER);
        mockUser.setAddress(mockAddress);
        mockUser.setCreatedAt(LocalDateTime.now());
        mockUser.setUpdatedAt(LocalDateTime.now());
        return mockUser;
    }
    @Test
    void createUserTest() {
        User user = createMockUser() ;
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User addedUser = userService.createUser(user);
        assertEquals(addedUser,user);
    }
    @Test
    void getUserByIdSuccessTest()
    {
        User user = createMockUser();
        Long id = 12L;
        user.setId(id);
        UserResponse userResponse = UserMapper.userToUserResponse(user);
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(user));
        UserResponse actualuserResponse =userService.getUserById(id);
        Assertions.assertNotNull(actualuserResponse);
        assertEquals(actualuserResponse,userResponse);
    }


    @Test
    void runTest(){
        System.out.println("Running our first Test case");
    }
}
