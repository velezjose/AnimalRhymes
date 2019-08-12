package com.animalrhymes.utils;

import com.animalrhymes.exceptions.SavageException;

public enum Config {
	APP_ID(System.getenv().get("ANIMAL_RHYMES_APP_ID")), APP_KEY(System.getenv().get("ANIMAL_RHYMES_APP_KEY"));

	private final String value;

	private Config(String value) {
		this.value = value;
	}

	public String getValue() throws SavageException {
		if (value == null) {
			if (Config.APP_ID == this) {
				throw new SavageException("Could not get Application ID (APP_ID) from the running environment.\n" +
					"See Step #9 from https://github.com/velezjose/AnimalRhymes.");
			} else if (Config.APP_KEY == this) {
				throw new SavageException("Could not get Application Key (APP_KEY) from the running environment.\n" +
					"See Step #10 from https://github.com/velezjose/AnimalRhymes.");
			}
		}

		return value;
	}
}
