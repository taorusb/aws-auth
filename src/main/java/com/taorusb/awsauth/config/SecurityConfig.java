package com.taorusb.awsauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@Profile("dev")
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeHttpRequests(authz -> authz.requestMatchers("/")
						.permitAll()
						.anyRequest()
						.authenticated())
				.oauth2Login()
				.defaultSuccessUrl("/", true)
				.and()
				.logout()
				.logoutSuccessUrl("/");
		return http.build();
	}
}
