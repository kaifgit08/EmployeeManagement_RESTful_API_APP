package com.gl.service;

import java.util.List;

import com.gl.entity.Role;

public interface RoleService {

	Role addRole(Role role);

	List<Role> getAllRoles();

}