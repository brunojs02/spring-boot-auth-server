package com.brunojs02.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brunojs02.authserver.entities.UserEntity;
import com.brunojs02.authserver.repositories.UserRepository;

@Service
public class UserCustomDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.getByUsername(username);
		if (user != null) {
			return new UserCustomDetails(user);
		}
		throw new UsernameNotFoundException("Usuário " + username + " não encontrado");
	}

}
