package com.restservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final String USER_URL = "/user";
	private final String LOGIN_URL = "/login";
	private final String PASSWORD = "agus";
        private final String USER = "admin";

	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication().withUser(USER).password(passwordEncoder().encode(PASSWORD)).roles("ADMIN");
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, USER_URL).permitAll()
            .antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
            .anyRequest().authenticated().and()
            	.addFilter(new JWTAuthenticationFilter(authenticationManager()))
            	.addFilter(new JWTAuthorizationFilter(authenticationManager()))
            ;
    }
}
     
