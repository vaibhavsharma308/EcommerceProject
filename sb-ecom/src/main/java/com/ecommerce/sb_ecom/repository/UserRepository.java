package com.ecommerce.sb_ecom.repository;

import com.ecommerce.sb_ecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
