package com.animalrhymes.server;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * The Rhyme Engine that gets a phonetic and matches it with a list of animals an returns that list
 * in the utility method getAnimalsThatRhymeWith(String word)
 */
public class RhymeEngine {
    private final static String FILENAME = "AnimalsAndPhonetic.csv";

    private final static Map<String, List<String>> HM = new HashMap<>();
    private final static boolean createdHashMap = false;
    private final static String[] DEFAULT_EMPTY_LIST = new String[] {};

    public final static RhymeEngine init() {
        return new RhymeEngine();
    }

    // Create HashMap from phonetic –> list of animals
    private RhymeEngine() {
        if (!Files.exists(Paths.get(FILENAME))) {
            AnimalAndPhoneticFileCreator.createFile();
        }

        if (!createdHashMap) {
            String line = null;
            try (FileReader fileReader = new FileReader(FILENAME);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                // First line is Animal,Phonetic. Skip it.
                line = bufferedReader.readLine();

                while ((line = bufferedReader.readLine()) != null) {
                    String[] animalAndPhonetic = line.split(",");
                    if (animalAndPhonetic.length < 2 || animalAndPhonetic[1].equals("OT FOUN")) continue;

                    String animal = animalAndPhonetic[0];
                    String phonetic = animalAndPhonetic[1];

                    for (int i = 0; i < phonetic.length(); i++) {
                        String phoneticSubstr = phonetic.substring(i);
                        System.out.println("KEY: " + phoneticSubstr);

                        List<String> list = HM.get(phoneticSubstr);
                        System.out.println("VALUE: " + list);

                         if (list == null) {
                             list = new ArrayList<String>();
                             // Add the animal to the end of the list
                         }
                        list.add(animal);
                        // Add the newly created list to the hash map
                        HM.put(phoneticSubstr, list);

                        System.out.println("AUGMENTED LIST: " + list.toString());
                    }
                }

            } catch (IOException ioe) {
                System.err.println("IOException thrown!");
                ioe.printStackTrace();
            }
        }
    }

    public static String[] getAnimalsThatRhymeWith(String word) {
        String wordPhonetic = WordPhoneticGetter.getPhonetic(word);

        System.out.println("Phonetic -> " + wordPhonetic + ", Word -> " + word);

        if (wordPhonetic.equals("")) {
            return DEFAULT_EMPTY_LIST;
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
