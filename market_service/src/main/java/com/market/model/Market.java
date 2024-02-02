package com.market.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Market {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer userId;
    private String username;




}
