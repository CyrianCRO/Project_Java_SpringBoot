package com.groupe6.atelier3.lib.DTO;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CardUserDTO  {
	
	public Integer id;
	public String username;
	public String password;
	public int money;
	
	public CardUserDTO() {
	}
	
	public CardUserDTO(Integer userId, String username) {
        this.id = userId;
        this.username = username;
    }	
}
