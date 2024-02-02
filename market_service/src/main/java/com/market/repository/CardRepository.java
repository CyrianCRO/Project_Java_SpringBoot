package com.market.repository;


import com.market.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>{
	public ArrayList<Card> findByUserUserId(int user);
	public Card save(Card newCard);

}
