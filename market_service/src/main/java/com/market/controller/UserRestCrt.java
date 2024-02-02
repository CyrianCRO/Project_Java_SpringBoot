package com.market.controller;

import com.market.model.CardUser;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class UserRestCrt {
	@Autowired
	private UserService uService;
	
	@RequestMapping(value = { "/createUser" }, method = RequestMethod.POST)
	public ResponseEntity<CardUser> createUser(@RequestBody Map<String, String> request) {
		CardUser newUser = uService.createUser(request.get("username"), request.get("password"));
		return ResponseEntity.ok(newUser);
	}


	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ResponseEntity<Integer> login(@RequestBody Map<String, String> request) {
		return ResponseEntity.ok(uService.authUser(request.get("username"), request.get("password")));
	}


	@RequestMapping(value = { "/user/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<CardUser> getUser(@PathVariable("id") Integer  id) {
		return ResponseEntity.ok(uService.getUserById(id));
	}
}
