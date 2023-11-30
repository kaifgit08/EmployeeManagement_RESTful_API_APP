package com.gl.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "u1")
public class User {
	@Id
	int id;
	String username;
	String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "u1_r1", joinColumns = @JoinColumn(name = "u_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "r_id", referencedColumnName = "id"))
	Set<Role> roles;
}
