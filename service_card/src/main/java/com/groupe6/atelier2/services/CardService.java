package com.groupe6.atelier2.services;

import java.util.ArrayList;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupe6.atelier2.models.Card;
import com.groupe6.atelier2.models.CardUser;
import com.groupe6.atelier2.repo.CardRepository;
import com.groupe6.atelier2.repo.UserRepository;

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


