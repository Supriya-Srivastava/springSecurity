
package com.example.securepp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authProvider() {

		DaoAuthenticationProvider daouth = new DaoAuthenticationProvider();

		daouth.setUserDetailsService(userDetailsService);

		daouth.setPasswordEncoder(new BCryptPasswordEncoder());
		return daouth;

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests().antMatchers("/login").permitAll().and()
		.formLogin().loginPage("/login").permitAll()
		.and().logout().invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout-success").permitAll();
		
		
		
	}

	
	
	
	
	
	
	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * List<UserDetails> user = new ArrayList<>();
	 * 
	 * user.add(User.withDefaultPasswordEncoder().username("supriya").password(
	 * "1234").roles("User").build());
	 * 
	 * 
	 * return new InMemoryUserDetailsManager(user); return
	 * super.userDetailsService();
	 */

}