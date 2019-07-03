package interfaces;

import models.Sightings;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class SqlSightingsInterfaceTest {
    private static Connection conn;
    private static SqlSightingsInterface sqlSightingsInterface;

    @BeforeClass
    public static void setUp() throws Exception{
        String establishConn = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
        Sql2o sql2o = new Sql2o(establishConn,"rlgriff","547");
        sqlSightingsInterface = new SqlSightingsInterface(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("Clearing database");
        sqlSightingsInterface.clearAllSightings();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection closed");
    }

    public Sightings setUpSighting(){
        return new Sightings("Lion", "Panthera leo", "John Doe", "Kenya");
    }
    @Test
    public void addsSightingAndSetsId() throws Exception{
        Sightings sightings = setUpSighting();
        sqlSightingsInterface.addSighting(sightings);
        int theId = sightings.getId();
        assertEquals(theId, sightings.getId());
    }

    @Test
    public void getsAllSightingsRecorded() {
        Sightings first = setUpSighting();
        Sightings second = setUpSighting();
        sqlSightingsInterface.addSighting(first);
        sqlSightingsInterface.addSighting(second);
        assertEquals(sqlSightingsInterface.getAllSightings().size(), 2);
    }

    @Test
    public void findsTheCorrectSghtingById() {
        Sightings first = setUpSighting();
        Sightings second = setUpSighting();
        sqlSightingsInterface.addSighting(first);
        sqlSightingsInterface.addSighting(second);
        Sightings found = sqlSightingsInterface.findSighting(second.getId());
        assertEquals(second, found);
    }
}