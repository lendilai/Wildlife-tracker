package interfaces;

import models.Ranger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.*;




import static org.junit.Assert.*;


public class SqlRangerInterfaceTest {
    private Connection conn;
    private SqlRangerInterface sqlRangerInterface;

    @Before
    public void setUp() throws Exception{
        String establishConn = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(establishConn,"","");
        sqlRangerInterface = new SqlRangerInterface(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception{
        conn.close();
    }

    @Test
    public void addJobAndSetsId() throws Exception {
        Ranger ranger = setupRanger();
        int firstId = ranger.getId();
        sqlRangerInterface.add(ranger);
        assertEquals(firstId,ranger.getId());
    }
    @Test
    public void getRangerById() throws Exception{
        Ranger existingRanger = new Ranger("Backend",89556);
        sqlRangerInterface.add(existingRanger);
        Ranger fetchJob =  sqlRangerInterface.findById(existingRanger.getId());
        assertEquals(existingRanger, fetchJob);

    }

    public Ranger setupRanger(){
        return new Ranger("frontend",97865746);
    }
}
