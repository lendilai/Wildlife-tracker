package interfaces;

import models.Ranger;
import org.junit.*;
import org.sql2o.*;




import static org.junit.Assert.*;


public class SqlRangerInterfaceTest {
    private static Connection conn;
    private static SqlRangerInterface sqlRangerInterface;

    @BeforeClass
    public static void setUp() throws Exception{
        String establishConn = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
        Sql2o sql2o = new Sql2o(establishConn,"rlgriff","547");
        sqlRangerInterface = new SqlRangerInterface(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("Clearing database");
        sqlRangerInterface.clearAllRangers();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void addJobAndSetsId() throws Exception {
        Ranger ranger = setupRanger();
        sqlRangerInterface.add(ranger);
        int firstId = ranger.getId();
        assertEquals(firstId,ranger.getId());
    }
    @Test
    public void getRangerById() throws Exception{
        Ranger existingRanger = new Ranger("Backend",89556);
        sqlRangerInterface.add(existingRanger);
        Ranger fetchJob =  sqlRangerInterface.findById(existingRanger.getId());
        assertEquals(existingRanger, fetchJob);

    }

    @Test
    public void rangerListIsEmptyOnInstantiation() throws Exception{
        assertEquals(0, sqlRangerInterface.getAll().size());
    }

    @Test
    public void deletesARanger() {
        Ranger newRanger = setupRanger();
        Ranger second = setupRanger();
        sqlRangerInterface.add(newRanger);
        sqlRangerInterface.add(second);
        sqlRangerInterface.delete(newRanger.getId());
        assertEquals(1, sqlRangerInterface.getAll().size());
    }

    public Ranger setupRanger(){
        return new Ranger("frontend",97865746);
    }
}
