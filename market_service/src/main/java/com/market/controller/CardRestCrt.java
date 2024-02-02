package com.market.controller;


import com.market.model.Card;
import com.market.model.CardUser;
import com.market.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

	//@RequestMapping(value = { "/card/listAllCard" }, method = RequestMethod.GET)

	@GetMapping("/card/list")
	public ResponseEntity<?>listAllCards() {
		return ResponseEntity.ok(cService.listAllCards());
	}
	
}
