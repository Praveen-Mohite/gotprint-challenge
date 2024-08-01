package com.gotprint.challenge.notesapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotprint.challenge.notesapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmailId(String emailId);
}
