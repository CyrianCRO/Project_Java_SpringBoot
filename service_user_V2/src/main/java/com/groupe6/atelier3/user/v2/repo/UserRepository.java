package com.groupe6.atelier3.user.v2.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupe6.atelier3.lib.models.CardUser;

@Repository
public interface UserRepository extends JpaRepository<CardUser, Integer>{
	public CardUser findByUsername(String username);
	public Optional<CardUser> findById(Integer id);
	public CardUser save(CardUser newUser);
	public void deleteById(Integer id);
	public List<CardUser> findAll();
}
