package com.brunojs02.authserver.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.brunojs02.authserver.entities.UserEntity;

public class UserCustomDetails extends User {

	private static final long serialVersionUID = 1L;
	private Long id;

	public UserCustomDetails(UserEntity user) {
		super(user.getUsername(), user.getPassword(), getRoles());
		this.id = user.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private static Collection<GrantedAuthority> getRoles() {
		Collection<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return roles;
	}

}
