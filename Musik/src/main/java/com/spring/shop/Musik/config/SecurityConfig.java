package com.spring.shop.Musik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


/**
 * @author Sourabh
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("user1").authorities("ROLE_USER");
		auth.inMemoryAuthentication().withUser("admin").password("123456").authorities("ROLE_ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
		.and().formLogin();
		
		 /*http
         .authorizeRequests()
         .antMatchers("/login*").anonymous()
         .anyRequest().authenticated()
         .and()
         .formLogin()
         .loginPage("/login.html")
         .defaultSuccessUrl("/index.html/#/home")
         .failureUrl("/login.html?error=true")
         .and()
         .logout().logoutSuccessUrl("/login.html");*/

	}
	
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}