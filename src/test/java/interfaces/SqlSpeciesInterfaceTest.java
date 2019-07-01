package interfaces;

import models.Species;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.*;

import static org.junit.Assert.*;

public class SqlSpeciesInterfaceTest {

    private SqlSpeciesInterface sqlSpeciesInterface;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String establishConn = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(establishConn,"","");
        sqlSpeciesInterface = new SqlSpeciesInterface(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addsSpeciesAndSetsId() throws Exception{
        Species species = new Species("Panthera Leo");
        int theId = species.getId();
        sqlSpeciesInterface.add(species);
        assertEquals(theId, species.getId());
    }

    @Test
    public void getsAllSpeciesAdded() {
        Species first = new Species("Panthera Leo");
        Species second = new Species("Mimosa pudica");
        sqlSpeciesInterface.add(first);
        sqlSpeciesInterface.add(second);
        assertEquals(2, sqlSpeciesInterface.getAll().size());
    }

    @Test
    public void fetchesCorrectSpeciesById() {
        Species theSpecies = new Species("Panthera Leo");
        sqlSpeciesInterface.add(theSpecies);
        Species found = sqlSpeciesInterface.findById(theSpecies.getId());
        assertEquals(theSpecies, found);
    }
}