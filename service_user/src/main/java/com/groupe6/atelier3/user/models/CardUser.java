package com.groupe6.atelier3.user.models;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class CardUser implements Serializable , UserDetails {
	
	private static final long serialVersionUID = 1L;

	public void setMoney(int money) {
		this.money = money;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String username;
	private String password;
	private int money;
	
	public CardUser() {}
	
	
	public CardUser(Integer userId) {
		this.userId = userId;
	}
	
	public CardUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}
	
	public Integer getId() {
		return this.userId;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void setId(int id) {
        this.userId = id;
    }


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
