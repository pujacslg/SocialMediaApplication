package com.cs.social.media.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMediaAppGlobalExceptionHandler {

	@ExceptionHandler(value = SocialMediaAppUserDoesNotExistException.class)
	public ResponseEntity SocialMediaAppUserDoesNotExistException(
			SocialMediaAppUserDoesNotExistException socialMediaAppUserDoesNotExistException) {
		return new ResponseEntity("User Does Not Exist", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = SocialMediaAppUserAlreadyExistsException.class)
	public ResponseEntity SocialMediaAppUserAlreadyExistsException(
			SocialMediaAppUserAlreadyExistsException socialMediaAppUserAlreadyExistsException) {
		return new ResponseEntity("User Already Exists", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = SocialMediaAppAlreadyFollowingException.class)
	public ResponseEntity SocialMediaAppAlreadyFollowingException(
			SocialMediaAppAlreadyFollowingException socialMediaAppAlreadyFollowingException) {
		return new ResponseEntity("Already Following This User", HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value = SocialMediaAppUserNotFollowingException.class)
	public ResponseEntity SocialMediaAppUserNotFollowingException(
			SocialMediaAppUserNotFollowingException socialMediaAppUserNotFollowingException) {
		return new ResponseEntity("Not Following This User", HttpStatus.CONFLICT);
	}
	
}
