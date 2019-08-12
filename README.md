# The Savage Animal Rhymes App

Alright bros, the moment you've all been waiting for. Animal rhymes is here and it's about to blow your 
minds! Get ready! Cause it's coming! And it's gonna be savage! 

**We welcome pull requests!** (especially if we're missing any animals in our 
[Animals.java](https://github.com/velezjose/AnimalRhymes/blob/master/backend/src/main/java/utils/Animals.java) class.)

## Loose API Documentation
*GET* `/savageRhymes?q={query}`: Returns animals that rhyme with query.
Query can be arbitrarily long. Results should rhyme with the last one or two syllables, or fake it 'til it makes it.
Returns 
`{
  "results": [
    ...
  ]
}`.

For example, `/savageRhymes?q=yo` returns `{ "results": [
                                                "Armadillo",
                                                "Bongo",
                                                "Bonobo",
                                                "Buffalo",
                                                "Dingo",
                                                "Dodo",
                                                "Dogue De Bordeaux",
                                                "Flamingo",
                                                "Gecko",
                                                "Kakapo",
                                                "Leaf-Tailed Gecko",
                                                "Pink Fairy Armadillo",
                                                "Sparrow",
                                                "Water Buffalo"
                                                ] }`. 

## To install and run on your computer
1. Open a terminal session.

2. `git clone https://github.com/velezjose/AnimalRhymes.git` (Unless you want to fork and then clone your fork.)

3. `cd AnimalRhymes/frontend # switch to frontend directory`

4. `npm i && npm run start # install dependencies and run frontend`

5. Leave the frontend running.

6. Go to [the Oxford Dictionaries Developer page](https://developer.oxforddictionaries.com/) and sign up for the 
PROTOTYPE (free) account. You should be able to get an **Application ID** and an **Application Key** that will 
serve as the keys that our rhyme engine will use to get the phonetic for rhyme pairing! (Note: The app won't work 
without these keys.)

7. **Open new terminal** (`CMD + t`).

8. `cd ../backend # switch to backend directory`

9. `export ANIMAL_RHYMES_APP_ID="<APP_ID_FROM_OXFORD_API_GOES_HERE>" # export Application Id as env variable`

10. `export ANIMAL_RHYMES_APP_KEY="<APP_KEY_FROM_OXFORD_API_GOES_HERE>" # same thing for Application Key`. Note for steps 9 and 10, you should
not wrap your API keys in smart quotes. API keys should be wrapped in regular quotes (non-smart).

11. `mvn spring-boot:run # inside backend directory`

12. Go to http://localhost:3000.

Enjoy said the [koi](https://en.wikipedia.org/wiki/Koi)!
