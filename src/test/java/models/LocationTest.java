package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void newLocation_instantiatesCorrectly() {
        Location newLocation = new Location("Kenya");
        assertEquals(true,newLocation instanceof Location);
    }

    @Test
    public void getsCorrectLocation_Kenya() throws Exception{
        Location newLocation = new Location("Kenya");
        assertEquals("Kenya", newLocation.getLocation());
    }
}