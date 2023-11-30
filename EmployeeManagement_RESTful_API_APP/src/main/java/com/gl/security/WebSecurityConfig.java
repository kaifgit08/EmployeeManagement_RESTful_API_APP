package com.gl.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/employees").hasAuthority("admin")
				.antMatchers(HttpMethod.GET, "/api/employees").hasAnyAuthority("user", "admin")
				.antMatchers(HttpMethod.GET, "/api/employees/**").hasAnyAuthority("user", "admin")
				.antMatchers(HttpMethod.GET, "/api/employees/sort?**").hasAnyAuthority("user", "admin")
				.antMatchers(HttpMethod.GET, "/api/employees/search/**").hasAnyAuthority("user", "admin")
				.antMatchers(HttpMethod.PUT, "/api/employees").hasAuthority("admin")
				.antMatchers(HttpMethod.DELETE, "/api/employees/**").hasAuthority("admin")
				.antMatchers(HttpMethod.GET, "/admin/").hasAuthority("admin")
				.antMatchers(HttpMethod.GET, "/admin/users").hasAuthority("admin")
				.antMatchers(HttpMethod.GET, "/admin/roles").hasAuthority("admin")
				.antMatchers(HttpMethod.POST, "/admin/users").hasAuthority("admin")
				.antMatchers(HttpMethod.POST, "/admin/roles").hasAuthority("admin").anyRequest().authenticated().and()
				.httpBasic().and().cors().and().csrf().disable();

	}

}
