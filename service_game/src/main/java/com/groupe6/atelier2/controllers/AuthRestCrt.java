package com.groupe6.atelier2.controllers;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.groupe6.atelier2.services.UserService;

@RestController
public class AuthRestCrt {
	
	@Autowired
	private UserService uService;
	
	@RequestMapping(value = { "/auth" }, method = RequestMethod.POST)
	public ResponseEntity<Integer> authUser(@RequestBody Map<String, String> request) {
		int userId = uService.authUser(request.get("username"), request.get("password"));
		return ResponseEntity.ok(userId);
	}
}
