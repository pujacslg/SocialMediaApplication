package com.cs.social.media.exception;

public class SocialMediaAppAlreadyFollowingException extends RuntimeException {
	private String message;

	public SocialMediaAppAlreadyFollowingException(String message) {
		super(message);
		this.message = message;
	}

	public SocialMediaAppAlreadyFollowingException() {
	}
}
