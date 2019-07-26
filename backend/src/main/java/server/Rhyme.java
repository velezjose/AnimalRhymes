package com.animalrhymes.server;

/*
 * A Rhyme contains a list of words (animals) that rhyme with another word.
 */
public class Rhyme {
    private final String[] RESULTS;

    public Rhyme(String word) {
        String[] results = RhymeEngine.getAnimalsThatRhymeWith(word);
        this.RESULTS = results;
    }

    public String[] getResults() {
        return this.RESULTS;
    }
}
