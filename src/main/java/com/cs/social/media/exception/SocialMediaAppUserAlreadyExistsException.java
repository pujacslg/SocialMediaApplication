package com.cs.social.media.exception;

public class SocialMediaAppUserAlreadyExistsException extends RuntimeException {
	private String message;

	public SocialMediaAppUserAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}

	public SocialMediaAppUserAlreadyExistsException() {
	}
}
