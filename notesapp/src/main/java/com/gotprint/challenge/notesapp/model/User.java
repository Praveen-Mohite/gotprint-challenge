package com.gotprint.challenge.notesapp.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Email
	@Column(nullable = false, unique = true)
	private String emailId;
	

	@Size(min = 15, max = 50)
	private String password;
	
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
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	
	public LocalDateTime getLastUpdateTime() {
		return lastUpdateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailId=" + emailId + ", createTime=" + createTime + ", lastUpdateTime="
				+ lastUpdateTime + "]";
	}

}
