package interfaces;

import models.Animal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.*;

import static org.junit.Assert.*;
public class SqlAnimalInterfaceTest {

    private Connection conn;
    private SqlAnimalInterface sqlAnimalInterface;

    @Before
    public void setUp() throws Exception {
        String establishConn = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(establishConn,"","");
        sqlAnimalInterface = new SqlAnimalInterface(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addsAnimalAndSetsId() throws Exception{
        Animal newAnimal = new Animal("Lion", false);
        int theId = newAnimal.getId();
        sqlAnimalInterface.add(newAnimal);
        assertEquals(theId, newAnimal.getId());
    }

    @Test
    public void getsAllAnimalObjects() {
        Animal first = new Animal("Lion", false);
        Animal second = new Animal("Panda", true);
        sqlAnimalInterface.add(first);
        sqlAnimalInterface.add(second);
        assertEquals(2, sqlAnimalInterface.getAll().size());
    }
}