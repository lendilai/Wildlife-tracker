package interfaces;

import models.Animal;
import org.junit.*;
import org.sql2o.*;

import static org.junit.Assert.*;
public class SqlAnimalInterfaceTest {

    private static Connection conn;
    private static SqlAnimalInterface sqlAnimalInterface;

    @BeforeClass
    public static void setUp() throws Exception{
        String establishConn = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
        Sql2o sql2o = new Sql2o(establishConn,"rlgriff","547");
        sqlAnimalInterface = new SqlAnimalInterface(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("Clearing database");
        sqlAnimalInterface.clearAllAnimals();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void addsAnimalAndSetsId() throws Exception{
        Animal newAnimal = new Animal("Lion", "Okay", "New-born", false);
        sqlAnimalInterface.add(newAnimal);
        int theId = newAnimal.getId();
        assertEquals(theId, newAnimal.getId());
    }

    @Test
    public void getsAllAnimalObjects() {
        Animal first = new Animal("Lion", "Okay", "New-born", false);
        sqlAnimalInterface.add(first);
        assertEquals(1, sqlAnimalInterface.getAll().size());
    }

    @Test
    public void fetchesCorrectAnimal() {
        Animal theAnimal = new Animal("Lion", "Poor", "Prime-Adult", false);
        sqlAnimalInterface.add(theAnimal);
        Animal found = sqlAnimalInterface.findById(theAnimal.getId());
        assertEquals(theAnimal, found);
    }
}