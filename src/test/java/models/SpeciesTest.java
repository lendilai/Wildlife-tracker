package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpeciesTest {

    @Test
    public void newSpecies_instantiatesCorrectly() {
        Species newSpecies = new Species("Panthera Leo");
        assertTrue(newSpecies instanceof Species);
    }

    @Test
    public void getsCorrectSpecies() {
        Species newSpecies = new Species("Panthera Leo");
        assertEquals("Panthera Leo", newSpecies.getThe_name());
    }
}