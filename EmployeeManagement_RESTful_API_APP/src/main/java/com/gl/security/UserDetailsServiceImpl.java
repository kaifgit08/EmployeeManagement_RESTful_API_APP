package com.gl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.entity.User;
import com.gl.dao.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("++++" + username);
		User user = userRepository.findByUsername(username);
		System.out.println("+++" + user);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		System.out.println(user);
		return new MyUserDetails(user);
	}
}