CREATE DATABASE wildlife_tracker;
\c wildlife_tracker;

 CREATE TABLE rangers(
    id SERIAL PRIMARY KEY,
    ranger VARCHAR,
     badge int
 );

 CREATE TABLE locations(
    id PRIMARY KEY,
    location VARCHAR,
 );


 CREATE TABLE species(
    id SERIAL PRIMARY KEY,
    the_name VARCHAR,
 );

 CREATE TABLE animals(id SERIAL PRIMARY KEY,the_name VARCHAR endangered boolean);

 CREATE TABLE sightings(id SERIAL PRIMARY KEY, ranger_id VARCHAR, species_id VARCHAR, animal_id VARCHAR,location_id VARCHAR, health VARCHAR, age VARCHAR, sighted_on timestamp);

 CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
