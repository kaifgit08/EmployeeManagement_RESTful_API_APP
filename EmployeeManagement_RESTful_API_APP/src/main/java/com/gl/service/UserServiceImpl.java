package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.UserRepository;
import com.gl.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userDao;

	@Override
	public User saveUser(User user) {
		return userDao.save(user);

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
}
