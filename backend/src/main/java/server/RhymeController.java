package com.animalrhymes.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class RhymeController {
    @RequestMapping(value="/savageRhymes", method=RequestMethod.GET)
    public Rhyme savageRhymes(@RequestParam(value="q", defaultValue="bird") String word) {
        return new Rhyme(word);
    }
}
