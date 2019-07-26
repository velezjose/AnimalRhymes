package com.animalrhymes.server;

import com.jayway.jsonpath.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Class with one sole purpose: return the phonetic of some word using utility method getPhonetic(String word)
 */
public class WordPhoneticGetter {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://googledictionaryapi.eu-gb.mybluemix.net/?define=";

    public static String getPhonetic(String word) {
        try {
            String json = sendGET(word);
            List<String> phonetic = JsonPath.read(json, "$.*.phonetic");
            String phoneticWithSlashes;

            if (phonetic.size() != 0) {
                phoneticWithSlashes = phonetic.get(0);
                return phoneticWithSlashes.substring(1, phoneticWithSlashes.length() - 1);
            } else {
                return "";
            }
        } catch (IOException ioe) {
            System.err.println("IOException thrown!");
            ioe.printStackTrace();
            return "";
        }
    }

    private static String sendGET(String word) throws IOException {
        URL obj = new URL(GET_URL + word);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.print("GET Response Code :: " + responseCode + "\n");

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            return "[ { \"phonetic\" : \"NOT FOUND\" } ]"; //default phonetic is no phonetic, i.e. empty str
        }
    }
}
