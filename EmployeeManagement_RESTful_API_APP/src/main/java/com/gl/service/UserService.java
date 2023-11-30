package com.gl.service;

import java.util.List;

import com.gl.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUsers();
}