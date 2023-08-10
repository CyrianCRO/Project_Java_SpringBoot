package com.groupe6.atelier.user.controllers;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groupe6.atelier3.user.models.CardUser;
import com.groupe6.atelier3.user.models.CardUserDTO;
import com.groupe6.atelier3.user.services.UserService;

@RestController
@CrossOrigin
public class UserRestCrt {
	@Autowired
	private UserService uService;
	
	@RequestMapping(value = { "/user" }, method = RequestMethod.POST)
	public ResponseEntity<CardUser> createUser(@RequestBody Map<String, String> request) {
		CardUser newUser = uService.createUser(request.get("username"), request.get("password"));
		return ResponseEntity.ok(newUser);
	}
	
	@RequestMapping(value = { "/user/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<CardUserDTO> getUser(@RequestParam("id") int id) {
		CardUserDTO user = uService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(value = { "/user/{username}" }, method = RequestMethod.GET)
	public ResponseEntity<CardUserDTO> getUserByUsername(@RequestParam("username") String username) {
		CardUserDTO user = uService.getUserByUsername(username);
		return ResponseEntity.ok(user);
	}
	
}
