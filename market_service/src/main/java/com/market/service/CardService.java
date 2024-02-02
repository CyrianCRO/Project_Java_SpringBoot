package com.market.service;


import com.market.model.Card;
import com.market.model.CardUser;
import com.market.repository.CardRepository;
import com.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	public ArrayList<Card> getCardsByUserId(int id){
		return cRepo.findByUserUserId(id);
	}
	
	public Card getCardById(int id) {
		Optional<Card> card = cRepo.findById(id);
		return card.get();
	}
	
	public Card addCard(Card newCard) {
		return cRepo.save(newCard);
	}

	public void deleteById(int cardId) {
		cRepo.deleteById(cardId);
	}
	
	public void listForSale(int cardId) {
		Optional<Card> card = cRepo.findById(cardId);
		card.get();
	}


	public List<Card> listAllCards() {
		return cRepo.findAll();

	}


    public Card updateCardUser(CardUser user, Integer idCard) {
		Optional<Card> cardOptional = cRepo.findById(idCard);
		Optional<CardUser> userOptional = uRepo.findById(user.getId());

		if(cardOptional.isPresent() && userOptional.isPresent()) {
			Card card = cardOptional.get();
			CardUser newUser = userOptional.get();
			card.setUser(newUser);
			card = cRepo.save(card);
			return card;
		}
		return null;
    }
    
    public CardUser getCardUser(Integer idCard) {
    	Optional<Card> cardOptional = cRepo.findById(idCard);
    	
    	if(cardOptional.isPresent()) {
    		Card card = cardOptional.get();
    		CardUser currentOwner = card.getUser();
    		return currentOwner;
    	}
    	return null;
    }
    
    public Card updateCardForSale(boolean status, Integer idCard) {
    	Optional<Card> cardOptional = cRepo.findById(idCard);
		
		if(cardOptional.isPresent()) {
			Card card = cardOptional.get();
			card.setForSale(status);
			card = cRepo.save(card);
			return card;
		}
    	return null;
    }
    
    public boolean getForSale(Integer idCard) {
    	Optional<Card> cardOptional = cRepo.findById(idCard);
    	
    	if(cardOptional.isPresent()) {
    		Card card = cardOptional.get();
    		boolean forSale = card.isForSale();
    		return forSale;
    	}
    	return false;
    }
    
    
    public int getPrice(Integer idCard) {
    	Optional<Card> cardOptional = cRepo.findById(idCard);
    	
    	if(cardOptional.isPresent()) {
    		Card card = cardOptional.get();
    		int price = card.getPrice();
    		return price;
    	}
    	return 0;
    } 
}


