package dev.kerem.pharmacy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.kerem.pharmacy.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").hasAnyAuthority(Constant.ADMIN)
			.antMatchers("/producers/**").hasAnyAuthority(Constant.USER, Constant.ADMIN)
			.antMatchers("/search/**").hasAnyAuthority(Constant.USER, Constant.ADMIN)
			.antMatchers("/medicines/**").hasAnyAuthority(Constant.USER, Constant.ADMIN)
			.antMatchers("/api/**").permitAll()
			.antMatchers("/").permitAll()
			.and()
			.formLogin()
			.and()
			.logout()
			.logoutSuccessUrl("/")
			.permitAll().and()
			.userDetailsService(userDetailsService())
			.csrf().disable();
	}
}
