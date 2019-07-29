package com.animalrhymes.server;

import java.io.*;
import java.util.List;

/*
 * Creates a .csv file with SomeAnimal,ItsPhonetic using the list of animals in Animals.java
 */
public class AnimalAndPhoneticFileCreator {
	private final static String FILENAME = "AnimalsAndPhonetic.csv";
	private final static String FIRSTLINE = "Animal,Phonetic";
	private final static String[] LIST_OF_ANIMALS = Animals.getAnimals();

	public static void createFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
			int len = LIST_OF_ANIMALS.length, curr = 0;

			writer.write(FIRSTLINE);
			writer.newLine();
			for (String animal : LIST_OF_ANIMALS) {
				String[] animalWords = animal.split(" ");
				String lastWordOfAnimal = animalWords[animalWords.length - 1];
				String phonetic = WordPhoneticGetter.getPhonetic(lastWordOfAnimal);
				System.out.println("Animal -> " + animal + ", Phonetic -> " + phonetic);

				if (phonetic.equals("NOT FOUND")) {
					System.out.println("REMOVE ANIMAL:" + animal);
					continue;
				}

				writer.write(animal + "," + phonetic);
				curr++;
				if (curr != len) writer.newLine();
			}

		} catch (IOException ioe) {
			System.err.println("IOException thrown!");
			ioe.printStackTrace();
		}
	}
}
