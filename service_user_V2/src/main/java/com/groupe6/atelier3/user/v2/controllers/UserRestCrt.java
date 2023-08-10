package com.groupe6.atelier3.user.v2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.groupe6.atelier3.lib.DTO.CardUserDTO;
import com.groupe6.atelier3.user.v2.services.UserService;
import com.groupe6.atelier3.lib.models.CardUser;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestCrt {

    @Autowired
    private UserService uService;

    // Create a new user
    @PostMapping("/user")
    public ResponseEntity<CardUser> createUser(@RequestBody Map<String, String> request) {
        CardUser newUser = uService.createUser(request.get("username"), request.get("password"));
        return ResponseEntity.ok(newUser);
    }

    // Get all users
    @GetMapping("/users")
    public ResponseEntity<List<CardUserDTO>> getAllUsers() {
        List<CardUserDTO> users = uService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get a user by ID
    @RequestMapping(value = { "/user/{id}" }, method = RequestMethod.GET)
    public ResponseEntity<CardUserDTO> getUser(@PathVariable("id") int id) {
        CardUserDTO user = uService.getUserById(id);
        return ResponseEntity.ok(user);
    }


    // Get a user by username
    @GetMapping("/user/username/{username}")
    public ResponseEntity<CardUser> getUserByUsername(@PathVariable("username") String username) {
        CardUser user = uService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    // Update a user
    @PutMapping("/user/{id}")
    public ResponseEntity<CardUser> updateUser(@PathVariable("id") int id, @RequestBody Map<String, String> request) {
        CardUser updatedUser = uService.updateUser(id, request.get("username"), request.get("password"));
        return ResponseEntity.ok(updatedUser);
    }

    // Delete a user
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        uService.deleteUser(id);
        return ResponseEntity.ok("User with ID " + id + " was successfully deleted.");
    }
}
