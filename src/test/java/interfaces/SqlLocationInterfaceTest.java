package interfaces;

import models.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.*;

import static org.junit.Assert.*;

public class SqlLocationInterfaceTest {

    private Connection conn;
    private SqlLocationInterface sqlLocationInterface;

    @Before
    public void setUp() throws Exception {
        String establishConn = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(establishConn,"","");
        sqlLocationInterface = new SqlLocationInterface(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addsLocationAndSetsId() throws Exception{
        Location newLocation = new Location("Kenya");
        int theId = newLocation.getId();
        sqlLocationInterface.add(newLocation);
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