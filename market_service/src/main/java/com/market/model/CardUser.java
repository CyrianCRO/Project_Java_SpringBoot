package com.market.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardUser {
	


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
	public void setMoney(int money) {
		this.money = money;
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
	
}
