package com.springBootMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springBootMVC.models.Users;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String email);
}