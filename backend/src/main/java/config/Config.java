package com.animalrhymes.server;

import java.util.Map;

public enum Config {
	APP_ID(System.getenv().get("APP_ID")), APP_KEY(System.getenv().get("APP_KEY"));

	private final String value;

	private Config(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
