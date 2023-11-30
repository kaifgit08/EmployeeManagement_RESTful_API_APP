package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.entity.Role;
import com.gl.entity.User;
import com.gl.service.RoleService;
import com.gl.service.UserService;

@RestController
@RequestMapping("/admin")
public class UserController {
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@RequestMapping("/")
	public String welcome() {
		return "This is my first Rest Api Application";
	}

	@PostMapping("/users")
	User saveUser(@RequestBody User user) {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));

		return userService.saveUser(user);

	}

	@PostMapping("/roles")
	Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);

	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/roles")
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}

}
