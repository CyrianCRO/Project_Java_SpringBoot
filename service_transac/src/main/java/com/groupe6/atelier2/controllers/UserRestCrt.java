package com.groupe6.atelier2.controllers;
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
import org.springframework.web.bind.annotation.RestController;

import com.groupe6.atelier2.models.CardUser;
import com.groupe6.atelier2.services.UserService;

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
}
