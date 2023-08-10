package com.groupe6.atelier3.user.v2.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupe6.atelier3.lib.DTO.CardUserDTO;
import com.groupe6.atelier3.lib.models.CardUser;
import com.groupe6.atelier3.user.v2.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;

	public List<CardUserDTO> getAllUsers() {
		return uRepo.findAll().stream()
				.map(user -> new CardUserDTO(user.getId(), user.getUsername()))
				.collect(Collectors.toList());
	}
		
	public CardUser getUserByUsername(String username) {
		CardUser user = uRepo.findByUsername(username);
		return user;
	}
	
	public CardUserDTO getUserById(Integer id) {
	    Optional<CardUser> userOptional = uRepo.findById(id);

	    if (userOptional.isPresent()) {
	        CardUser user = userOptional.get();
	        CardUserDTO cardUserDTO = new CardUserDTO(user.getId(), user.getUsername());
	        cardUserDTO.money = (user.getMoney());
	        return cardUserDTO;
	    }
	    return null;
	}

	
	public CardUser createUser(String username, String password) {
		CardUser newUser = new CardUser(username, password);
		return uRepo.save(newUser);
	}

	public CardUser updateUser(Integer id, String username, String password) {
		Optional<CardUser> userOptional = uRepo.findById(id);

		if(userOptional.isPresent()) {
			CardUser user = userOptional.get();
			user.setUsername(username);
			user.setPassword(password);
			return uRepo.save(user);
		}

		return null;
	}
	
	public void deleteUser(Integer id) {
		uRepo.deleteById(id);
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
