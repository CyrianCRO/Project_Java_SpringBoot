package com.groupe6.atelier3.auth.services;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.groupe6.atelier3.lib.DTO.CardUserDTO;
import com.groupe6.atelier3.lib.mappers.UserMapper;
import com.groupe6.atelier3.lib.models.CardUser;


@Service
public class AuthService implements UserDetailsService {
    @Autowired
	private RestTemplate restTemplate;
    @Autowired
    private UserMapper userMapper;
    
    public CardUserDTO getUsername(String username) {
        String apiUrl = "http://localhost:9999/api/user/username/" + username;
        
        try {
            CardUserDTO response = (CardUserDTO) restTemplate.getForObject(apiUrl, CardUserDTO.class);
            return response;
        } catch (RestClientException ex) {
            throw new UsernameNotFoundException("Error when trying to fetch user with username: " + username, ex);
        }
    }

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
        CardUserDTO user = getUsername(username);
        System.out.println(user.username);
        CardUser finalUser = UserMapper.toEntity(user);
        System.out.println(finalUser.getUsername());
        return finalUser;
    }
}




