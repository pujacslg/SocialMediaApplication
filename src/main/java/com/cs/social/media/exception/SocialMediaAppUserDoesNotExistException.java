package com.cs.social.media.exception;

public class SocialMediaAppUserDoesNotExistException extends RuntimeException {
	private String message;

	public SocialMediaAppUserDoesNotExistException(String message) {
		super(message);
		this.message = message;
	}

	public SocialMediaAppUserDoesNotExistException() {
	}
}
