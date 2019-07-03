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
        Sightings newSighting = new Sightings(1,1,1,1);
        assertTrue(newSighting instanceof Sightings);
    }

    @Test
    public void Sighting_instantiatesWithCorrectValues() {
        Sightings first = new Sightings(2,8,3,17);
        assertEquals(2, first.getAnimal_id());
        assertEquals(17, first.getLocation_id());
        assertEquals(3, first.getRanger_id());
        assertEquals(8, first.getSpecies_id());
    }
}