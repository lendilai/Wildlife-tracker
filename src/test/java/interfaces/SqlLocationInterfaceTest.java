package interfaces;

import models.Location;
import org.junit.*;
import org.sql2o.*;

import static org.junit.Assert.*;

public class SqlLocationInterfaceTest {

    private static Connection conn;
    private static SqlLocationInterface sqlLocationInterface;

    @BeforeClass
    public static void setUp() throws Exception{
        String establishConn = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
        Sql2o sql2o = new Sql2o(establishConn,"rlgriff","547");
        sqlLocationInterface = new SqlLocationInterface(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("Clearing database");
        sqlLocationInterface.clearAllLocations();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void addsLocationAndSetsId() throws Exception{
        Location newLocation = new Location("Kenya");
        sqlLocationInterface.add(newLocation);
        int theId = newLocation.getId();
        assertEquals(theId, newLocation.getId());
    }

    @Test
    public void getsAllLocationsAdded() {
        Location first = new Location("Kenya");
        Location second = new Location("Senegal");
        sqlLocationInterface.add(first);
        sqlLocationInterface.add(second);
        assertEquals(2,sqlLocationInterface.getAll().size());
    }

    @Test
    public void findsALocationByItsId() {
        Location myLocation = new Location("Kenya");
        sqlLocationInterface.add(myLocation);
        Location fetchLocation = sqlLocationInterface.findById(myLocation.getId());
        assertEquals(myLocation, fetchLocation);
    }
}