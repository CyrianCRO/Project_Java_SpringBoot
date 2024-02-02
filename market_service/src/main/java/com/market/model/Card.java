package com.market.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "CARD")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(name = "HP")
    private int hp;
    @Column(name = "DEFENCE")
    private int defence;
    @Column(name = "ATTACK")
    private int attack;
    @Column(name = "URL")
    private String url;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=true)
    private CardUser user;
    @Column(name = "FOR_SALE")
    private boolean forSale;
    @Column(name = "PRICE")
    private int price;

    public Card() {}

    public Card(String name, int hp, int defence, int attack, String url, CardUser user, boolean forSale) {
        this.name = name;
        this.hp = hp;
        this.defence = defence;
        this.attack = attack;
        this.url = url;
        this.forSale = forSale;
        this.user = user;
    }

    public CardUser getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setUser(CardUser user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public int getHp() {
        return hp;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttack() {
        return attack;
    }

    public String getUrl() {
        return url;
    }

    public boolean isForSale() {
        return forSale;
    }


    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public int getPrice() {
        return price;
    }

    public boolean isPresent() {
        // TODO Auto-generated method stub
        return false;
    }


}
