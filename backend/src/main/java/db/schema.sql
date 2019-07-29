CREATE DATABASE animal_rhymes;

USE animal_rhymes;

CREATE TABLE animals(
    animalId INT UNSIGNED NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phonetic VARCHAR(200) NOT NULL
);
