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
	private static final String GET_URL = "https://od-api.oxforddictionaries.com:443/api/v2/entries/en-us/";
	private static final String PRONUNCIATION_FIELD = "fields=pronunciations";
	private static int current = 0;

	public static String getPhonetic(String word) {
		// API only handles 500 rpm. This is a lazy way to handle this.
		current += 1;
		if (current == 499) {
			try {
				Thread.sleep(60000);
				current = 0;
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

		try {
			String json = sendGET(word);
			List<LinkedHashMap> phonetic = JsonPath.read(json, "$.results[0].lexicalEntries[0].pronunciations");

			for (LinkedHashMap lhm : phonetic) {
				if (lhm.get("phoneticNotation") != null && lhm.get("phoneticNotation").equals("IPA")) {
					return (String) lhm.get("phoneticSpelling");
				}
			}

			return "";
		} catch (IOException | PathNotFoundException ex) {
			// TODO: return 500 status to client
			System.err.println("IOException thrown!");
			ex.printStackTrace();
			return "";
		}
	}

	private static String sendGET(String word) throws IOException {
		URL obj = new URL(GET_URL + word.toLowerCase() + "?" + PRONUNCIATION_FIELD);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("app_id", Config.APP_ID.getValue());
		con.setRequestProperty("app_key", Config.APP_KEY.getValue());

		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

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
			// TODO: Return 500 status to client
			return "{ \"results\": [] }";
		}
	}
}
