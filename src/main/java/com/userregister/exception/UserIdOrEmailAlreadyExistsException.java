package com.userregister.exception;

public class UserIdOrEmailAlreadyExistsException extends RuntimeException {

	public UserIdOrEmailAlreadyExistsException() {
		super();

	}

	public UserIdOrEmailAlreadyExistsException(String message) {
		super(message);

	}

}
