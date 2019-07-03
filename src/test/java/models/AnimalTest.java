package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void newAnimal_instantiatesCorrectly() {
        Animal newAnimal = new Animal("Lion", "Good", "Young-Adult", false);
        assertTrue(newAnimal instanceof Animal);
    }

    @Test
    public void getsCorrectNameOfAnAnimalAndStatus() {
        Animal newAnimal = new Animal("Lion", "Okay", "New-Born", false);
        assertEquals("Lion", newAnimal.getThe_name());
        assertEquals(false, newAnimal.isEndangered());
    }
}