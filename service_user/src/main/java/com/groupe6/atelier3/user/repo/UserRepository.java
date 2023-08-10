package com.groupe6.atelier3.user.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.groupe6.atelier3.user.models.CardUser;

@Repository
public interface UserRepository extends CrudRepository<CardUser, Integer>{
	public CardUser findByUsername(String username);
	public Optional<CardUser> findById(Integer id);
	public CardUser save(CardUser newUser);
    Optional<CardUser> findUserByUsername(String username);
}
