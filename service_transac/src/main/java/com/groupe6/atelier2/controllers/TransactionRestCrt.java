package com.groupe6.atelier2.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe6.atelier2.models.Card;
import com.groupe6.atelier2.models.CardUser;
import com.groupe6.atelier2.services.TransactionService;

@RestController
@CrossOrigin
public class TransactionRestCrt {
	
	@Autowired
	private TransactionService tService;
	
	/**
	 * Handles the PUT request for buying a card.
	 * 
	 * @param json the JSON object containing the user data
	 * @param id the ID of the card to buy
	 * @return a ResponseEntity containing a message indicating whether the transaction was successful or not
	 */
	@ResponseBody
	@RequestMapping(value = { "/transaction/buy/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<String> buyCard(@RequestBody Map<String, Object> json, @PathVariable Integer id) {
	    // Convert JSON object to CardUser object
	    ObjectMapper mapper = new ObjectMapper();
	    CardUser user = mapper.convertValue(json.get("user"), CardUser.class);

	    // Call buyCard method of TransactionService and return its response
	    return tService.buyCard(user, id);	
	}

	
	/**
	 * Handles the PUT request for selling a card.
	 * 
	 * @param id the ID of the card to sell
	 * @return a ResponseEntity containing the updated Card object if the update was successful, or a custom error response if it failed
	 */
	@ResponseBody
	@RequestMapping(value = { "/transaction/sell/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<String> sellCard(@PathVariable Integer id) {
	    // Call sellCard method of TransactionService and return its response
	    return tService.sellCard(id);	
	}

}
