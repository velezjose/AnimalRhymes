package com.animalrhymes.engine;

import com.animalrhymes.exceptions.SavageException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "http://animal-rhymes.herokuapp.com")
public class RhymeController {
	@RequestMapping(value = "/savageRhymes", method = RequestMethod.GET)
	public Rhyme savageRhymes(@RequestParam(value = "q", defaultValue = "bird") String word) throws SavageException {
		String[] rhymes = RhymeEngine.getAnimalsThatRhymeWith(word);
		return new Rhyme(rhymes);
	}
}
