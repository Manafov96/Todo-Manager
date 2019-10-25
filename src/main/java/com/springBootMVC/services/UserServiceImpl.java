package com.springBootMVC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springBootMVC.models.Roles;
import com.springBootMVC.models.Users;
import com.springBootMVC.repository.RoleRespository;
import com.springBootMVC.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRespository roleRespository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Users findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Roles userRole = roleRespository.findByRole("ADMIN");
		user.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

}