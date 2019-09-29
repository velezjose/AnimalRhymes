package com.animalrhymes.engine;

import com.animalrhymes.exceptions.SavageException;
import com.animalrhymes.utils.AnimalAndPhoneticFileCreator;
import com.animalrhymes.utils.WordPhoneticGetter;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The Rhyme Engine that gets a phonetic and matches it with a list of animals an returns that list
 * in the utility method getAnimalsThatRhymeWith(String word)
 */
public class RhymeEngine {
	private final static String FILENAME = "AnimalsAndPhonetic.csv";

	private final static Map<String, List<String>> HM = new HashMap<>();
	private static boolean createdHashMap = false;
	private final static String[] DEFAULT_EMPTY_LIST = new String[]{};

	public final static RhymeEngine init() {
		return new RhymeEngine();
	}

	/**
	 * Create HashMap: String phonetic ——> List<String> animals
	 */
	private RhymeEngine() {
		if (!Files.exists(Paths.get(FILENAME))) {
			System.out.println("Creating " + FILENAME + " file because it does not exist...");
			AnimalAndPhoneticFileCreator.createFile();
			System.out.println("File created.");
		}

		if (!createdHashMap) {
			System.out.println("Creating HashMap for RhymeEngine...");
			String line = null;
			try (FileReader fileReader = new FileReader(FILENAME);
				 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

				// First line is Animal,Phonetic. Skip it.
				line = bufferedReader.readLine();

				while ((line = bufferedReader.readLine()) != null) {
					String[] animalAndPhonetic = line.split(",");
					if (animalAndPhonetic.length < 2) continue;

					String animal = animalAndPhonetic[0];
					String phonetic = animalAndPhonetic[1];

					for (int i = 0; i < phonetic.length(); i++) {
						String phoneticSubstr = phonetic.substring(i);

						List<String> list = HM.get(phoneticSubstr);

						if (list == null) {
							list = new ArrayList<String>();
							// Add the newly created list to the hash map
							HM.put(phoneticSubstr, list);
						}
						// Add the animal to the end of the list
						list.add(animal);
					}
				}
				createdHashMap = true;
				System.out.println("HashMap created successfully.");
			} catch (Exception e) {
				System.err.println("Could not create HashMap!");
				e.printStackTrace();
			}
		}
	}

	public static String[] getAnimalsThatRhymeWith(String word) throws SavageException {
		String wordPhonetic = WordPhoneticGetter.getPhonetic(word);

		System.out.println("Word -> " + word + ", Phonetic -> " + wordPhonetic + "\n");

		if (wordPhonetic.equals("PHONETIC NOT FOUND")) {
			return DEFAULT_EMPTY_LIST.clone();
		}

		for (int i = 0; i < wordPhonetic.length(); i += 1) {
			List<String> rhymes = HM.get(wordPhonetic.substring(i));
			if (rhymes != null) {
				return rhymes.toArray(new String[0]);
			}
		}

		return DEFAULT_EMPTY_LIST;
	}
}
