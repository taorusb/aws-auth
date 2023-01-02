package com.taorusb.awsauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebFluxSecurity
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
