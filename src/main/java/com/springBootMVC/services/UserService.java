package com.springBootMVC.services;

import com.springBootMVC.models.Users;

public interface UserService {

	public Users findUserByEmail(String email);

	public void saveUser(Users user);
}