package dev.kerem.pharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.kerem.pharmacy.models.User;
import dev.kerem.pharmacy.repositories.UserRepository;

@Component
public class DatabaseSeeder implements ApplicationRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public DatabaseSeeder(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (userRepository.findAll().size() == 0) {
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("admin"));
			admin.setRole(Constant.ADMIN);
			
			User producer = new User();
			producer.setUsername("user");
			producer.setPassword(passwordEncoder.encode("pass"));
			producer.setRole(Constant.USER);
			
			userRepository.save(admin);
			userRepository.save(producer);
		}
	}
	
}
