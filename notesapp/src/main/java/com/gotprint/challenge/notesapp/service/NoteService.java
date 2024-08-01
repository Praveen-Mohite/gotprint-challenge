package com.gotprint.challenge.notesapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gotprint.challenge.notesapp.model.Note;
import com.gotprint.challenge.notesapp.repository.NoteRepository;

import jakarta.validation.constraints.NotNull;

@Service
public class NoteService {

	private final NoteRepository noteRepository;
	
	public NoteService(final NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	public List<Note> findAllByUserId(@NotNull Long userId) {
		return noteRepository.findByUserId(userId);
	}
	
	public Optional<Note> findByNoteId(@NotNull Long noteId) {
		return noteRepository.findById(noteId);
	}

	public Note save(@NotNull Note note) {
		return noteRepository.save(note);
	}
	
	public void deleteByNoteId(@NotNull Long noteId) {
		noteRepository.deleteById(noteId);
	}

	
}
