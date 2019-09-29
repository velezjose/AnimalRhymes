package com.animalrhymes.utils;

import java.io.*;
import java.util.List;

/**
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

				if (phonetic.equals("PHONETIC NOT FOUND")) {
					System.out.println("REMOVE ANIMAL:" + animal);
					continue;
				}

				writer.write(animal + "," + phonetic);
				curr++;
				if (curr != len) writer.newLine();
			}

			return;
		} catch (IOException e) {
			System.err.println("Could not create file! Please try again.");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Exception thrown.");
			e.printStackTrace();
		}

		System.out.println("Exiting program. 1, 2,.. ");
		System.exit(0);
	}
}
