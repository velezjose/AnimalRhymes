package com.animalrhymes.exceptions;

public class SavageException extends Exception {
	private static final long serialVersionUID = 0L;

	public SavageException() {
		super();
	}

	public SavageException(String reason) {
		super(reason);
	}
}
