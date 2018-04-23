package com.financ.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;

@Entity
@Table(name = "scheduled_email")
public class ScheduledEmail extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "email", nullable = false)
	@JsonAlias(value = "email")
	private String email;

	@Column(name = "text", nullable = false)
	@JsonAlias(value = "text")
	private String text;

	@Column(name = "sent")
	@JsonAlias(value = "sent")
	private boolean sent = false;

	@Column(name = "subject", nullable = false)
	@JsonAlias(value = "subject")
	private String subject;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
