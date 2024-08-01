package com.gotprint.challenge.notesapp.service;

import org.springframework.stereotype.Service;

import com.gotprint.challenge.notesapp.model.User;
import com.gotprint.challenge.notesapp.repository.UserRepository;

import jakarta.validation.constraints.NotNull;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User findByEmail(@NotNull String emailId) {
		return userRepository.findByEmailId(emailId).orElse(null);
	}
	
	public User save(@NotNull User user) {
		return userRepository.save(user);
	}
	
}
