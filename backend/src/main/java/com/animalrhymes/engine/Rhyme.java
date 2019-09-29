package com.animalrhymes.engine;

/**
 * A Rhyme contains a list of words (animals) that rhyme with another word.
 */
public class Rhyme {
	private final String[] RESULTS;

	public Rhyme(String[] rhymes) {
		this.RESULTS = rhymes;
	}

	public String[] getResults() {
		return this.RESULTS;
	}
}
