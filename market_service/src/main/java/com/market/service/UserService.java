package com.market.service;

import com.market.model.CardUser;
import com.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	public CardUser getUserByUsername(String username) {
		CardUser user = uRepo.findByUsername(username);
		return user;
	}
	
	public CardUser getUserById(Integer id) {
		Optional<CardUser> userOptional = uRepo.findById(id);
		if(userOptional.isPresent()) {
			CardUser user = userOptional.get();
			return user;
		}
		return null;
	}
	
	public int authUser(String username, String password) {
		//If user does not exist or if the password does not match a 403 code is sent otherwise the ID of the user sent

		CardUser user = this.getUserByUsername(username);
		if (user == null) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User does not exist");
		}
		if (!user.getPassword().equals(password)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Password is not correct");
		}
		return user.getId();
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
