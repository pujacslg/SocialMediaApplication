package com.cs.social.media.exception;

public class SocialMediaAppUserNotFollowingException extends RuntimeException {
	private String message;

	public SocialMediaAppUserNotFollowingException(String message) {
		super(message);
		this.message = message;
	}

	public SocialMediaAppUserNotFollowingException() {
	}
}
