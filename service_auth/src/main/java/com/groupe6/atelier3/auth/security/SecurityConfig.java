package com.groupe6.atelier3.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.groupe6.atelier3.auth.controllers.AppAuthProvider;
import com.groupe6.atelier3.auth.controllers.JwtAuthEntryPoint;
import com.groupe6.atelier3.auth.controllers.JwtRequestFilter;
import com.groupe6.atelier3.auth.services.AuthService;

@EnableWebSecurity
public class SecurityConfig {
	private final AuthService authService;
    private final JwtAuthEntryPoint jwtAuthenticationEntryPoint;
	private final JwtRequestFilter jwtRequestFilter;
	private final PasswordEncoder passwordEncoder;
	public SecurityConfig( AuthService authService, 
							JwtAuthEntryPoint jwtAuthenticationEntryPoint,
							JwtRequestFilter jwtRequestFilter,
							PasswordEncoder passwordEncoder) {
		this.authService=authService;
		this.jwtAuthenticationEntryPoint=jwtAuthenticationEntryPoint;
		this.jwtRequestFilter=jwtRequestFilter;
		this.passwordEncoder=passwordEncoder;
	}

	// Security chain for JWT
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// use to allow direct login call without hidden value csfr (Cross Site Request
		// Forgery) needed
		http.csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http
				.authenticationProvider(getProvider())
				.authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers("/hero/**").authenticated()
				.anyRequest().authenticated();
		// Add a filter to validate the tokens with every request
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public AuthenticationProvider getProvider() {
		AppAuthProvider provider = new AppAuthProvider();
		provider.setUserDetailsService(authService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
		return authConfiguration.getAuthenticationManager();
	}
}
