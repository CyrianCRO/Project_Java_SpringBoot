package com.groupe6.atelier3.user.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.groupe6.atelier3.user.models.CardUser;
import com.groupe6.atelier3.user.models.CardUserDTO;
import com.groupe6.atelier3.user.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	public CardUserDTO getUserByUsername(String username) {
		CardUser user = uRepo.findByUsername(username);
		CardUserDTO userDTO = new CardUserDTO(user);

		
		return userDTO;
	}
	
	public CardUserDTO getUserById(Integer id) {
		Optional<CardUser> userOptional = uRepo.findById(id);
		if(userOptional.isPresent()) {
			CardUser user = userOptional.get();
			CardUserDTO userDTO = new CardUserDTO(user);
			return userDTO;
		}
		return null;
	}
	
	public CardUser createUser(String username, String password) {
		CardUser newUser = new CardUser(username, password);
		return uRepo.save(newUser);
	}
	
	public CardUser updateUserMoney(CardUser cardUser, int price) {
		Optional<CardUser> userOptional = uRepo.findById(cardUser.getId());

		if(userOptional.isPresent()) {
			CardUser cardUser1 = userOptional.get();
			cardUser1.setMoney(price);
			uRepo.save(cardUser1);
			return cardUser1;
		}
		return null;
	}
}
