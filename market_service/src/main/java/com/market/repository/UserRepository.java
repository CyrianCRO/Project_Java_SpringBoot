package com.market.repository;

import com.market.model.CardUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<CardUser, Integer> {
	public CardUser findByUsername(String username);
	public Optional<CardUser> findById(Integer id);
	public CardUser save(CardUser newUser);
	
}
