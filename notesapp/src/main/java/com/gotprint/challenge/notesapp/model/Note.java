package com.gotprint.challenge.notesapp.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Size;

@Entity
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noteId;
	
	@Nonnull
	@Size(max = 50)
	private String title;
	
	@Size(max = 1000)
	private String notesContent;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	private LocalDateTime createTime;
	private LocalDateTime lastUpdateTime;
	
	@PrePersist
	protected void onCreate() {
		createTime = LocalDateTime.now();
	}
	
	@PostPersist
	protected void onUpdate() {
		lastUpdateTime = LocalDateTime.now();
	}
	
	public Long getNoteId() {
		return noteId;
	}
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNotesContent() {
		return notesContent;
	}
	
	public void setNotesContent(String notesContent) {
		this.notesContent = notesContent;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	
	public LocalDateTime getLastUpdateTime() {
		return lastUpdateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(noteId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(noteId, other.noteId);
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", title=" + title + ", notesContent=" + notesContent + ", userID=" + user.getUserId()
				+ ", createTime=" + createTime + ", lastUpdateTime=" + lastUpdateTime + "]";
	}
	
}
