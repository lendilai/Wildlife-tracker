package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class SightingsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void newSighting_instantiatesCorrectly() {
        Sightings newSighting = new Sightings("Lion", "Panthera leo", "John Doe", "Kenya");
        assertTrue(newSighting instanceof Sightings);
    }

    @Test
    public void Sighting_instantiatesWithCorrectValues() {
        Sightings first = new Sightings("Lion", "Panthera leo", "John Doe", "Kenya");
        assertEquals("Lion", first.getAnimal_id());
        assertEquals("Kenya", first.getLocation_id());
        assertEquals("John Doe", first.getRanger_id());
        assertEquals("Panthera leo", first.getSpecies_id());
    }
}