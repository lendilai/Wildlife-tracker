package interfaces;

import models.Species;
import org.junit.*;
import org.sql2o.*;

import static org.junit.Assert.*;

public class SqlSpeciesInterfaceTest {

    private static SqlSpeciesInterface sqlSpeciesInterface;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception{
        String establishConn = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
        Sql2o sql2o = new Sql2o(establishConn,"rlgriff","547");
        sqlSpeciesInterface = new SqlSpeciesInterface(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("Clearing database");
        sqlSpeciesInterface.clearAllSpecies();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void addsSpeciesAndSetsId() throws Exception{
        Species species = new Species("Panthera Leo");
        sqlSpeciesInterface.add(species);
        int theId = species.getId();
        assertEquals(theId, species.getId());
    }

    @Test
    public void getsAllSpeciesAdded() {
        Species first = new Species("Panthera Leo");
        sqlSpeciesInterface.add(first);
        assertEquals(1, sqlSpeciesInterface.getAll().size());
    }

    @Test
    public void fetchesCorrectSpeciesById() {
        Species theSpecies = new Species("Panthera Leo");
        sqlSpeciesInterface.add(theSpecies);
        Species found = sqlSpeciesInterface.findById(theSpecies.getId());
        assertEquals(theSpecies, found);
    }
}