package dev.kerem.pharmacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dev.kerem.pharmacy.models.MyUserDetails;
import dev.kerem.pharmacy.models.User;
import dev.kerem.pharmacy.repositories.UserRepository;

public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		if (username == null) {
			throw new UsernameNotFoundException("Kullanıcı bulunamadı!");
		}
		
		return new MyUserDetails(user);
	}

}
