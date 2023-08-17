package space.bum.c5_ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.httpBasic()
				.and()
				.authorizeRequests()
					.anyRequest() // matcher method
						.hasAuthority("read")
				.and().build();
		// matcher method + authori' rule
		// 1. which matcher method can we use and how
		// 2. how apply different authori' rules
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		var uds = new InMemoryUserDetailsManager();
		var u1 = User.withUsername("park")
				.password(passwordEncoder().encode("1234"))
				.authorities("read").build();
		
		uds.createUser(u1);
		
		var u2 = User.withUsername("will")
				.password(passwordEncoder().encode("1234"))
				.authorities("write").build();
		
		uds.createUser(u2);
		return uds;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
}
