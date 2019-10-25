package com.springBootMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootMVC.models.Roles;

@Repository("roleRepository")
public interface RoleRespository extends JpaRepository<Roles, Integer> {

	Roles findByRole(String role);
}