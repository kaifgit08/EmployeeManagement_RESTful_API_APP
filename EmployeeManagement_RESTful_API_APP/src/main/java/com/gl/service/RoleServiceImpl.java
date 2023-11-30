package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.RoleRepository;
import com.gl.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository dao;

	@Override
	public Role addRole(Role role) {
		return dao.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
