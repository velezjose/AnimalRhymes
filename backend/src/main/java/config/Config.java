package com.animalrhymes.server;

public enum Config {
	APP_ID(System.getenv().get("ANIMAL_RHYMES_APP_ID")), APP_KEY(System.getenv().get("ANIMAL_RHYMES_APP_KEY"));

	private final String value;

	private Config(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
