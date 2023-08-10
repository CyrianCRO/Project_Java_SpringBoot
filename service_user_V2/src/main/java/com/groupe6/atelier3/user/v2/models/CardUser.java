package com.groupe6.atelier3.user.v2.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardUser implements Serializable {

    public void setPassword(String password) {
		this.password = password;
	}

	private static final long serialVersionUID = 1L;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return this.userId;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setId(int id) {
        this.userId = id;
    }
}
