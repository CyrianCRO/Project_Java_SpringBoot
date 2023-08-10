package com.groupe6.atelier2.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.groupe6.atelier2.models.Card;
import com.groupe6.atelier2.models.CardUser;
import com.groupe6.atelier2.services.CardService;


@RestController
@CrossOrigin
public class CardRestCrt {
	@Autowired
	private CardService cService;
	
	@RequestMapping(value = { "/cards/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList> getCardsByUserId(@PathVariable int id) {
		return ResponseEntity.ok(cService.getCardsByUserId(id));
	}
	
	@RequestMapping(value = { "/addCard" }, method = RequestMethod.POST)
	public void addCard(@RequestBody Map<String, Object> request) {
	    String name = request.get("name").toString();
	    String url = request.get("url").toString();
	    int hp = (int) request.get("hp");
	    int defence = (int) request.get("defence");
	    int attack = (int) request.get("attack");
	    boolean forSale = (boolean) request.get("forSale");
	    Integer userId = (Integer) request.get("userId");
	    CardUser user = new CardUser(userId);
	    Card newCard = new Card(name, hp, defence, attack, url, user, forSale);
		cService.addCard(newCard);
	}

	@RequestMapping(value = { "/cards/delete/{id}" }, method = RequestMethod.DELETE)
	public void deleteCardById(@PathVariable int id) {
		cService.deleteById(id);
	}
	
	@RequestMapping(value = { "/card/{id}" }, method = RequestMethod.GET)
	public Card getCardById(@PathVariable int id) {
		return cService.getCardById(id);
	}
	
}
