package com.groupe6.atelier2.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.groupe6.atelier2.models.Card;
import com.groupe6.atelier2.models.CardUser;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer>{
	public ArrayList<Card> findByUserUserId(int user);
	public Card save(Card newCard);

}
