package com.gotprint.challenge.notesapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotprint.challenge.notesapp.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

	List<Note> findByUserId(Long userId);
}
