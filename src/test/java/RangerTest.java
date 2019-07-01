import models.Ranger;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class RangerTest {

    @Test
    public void instantiatesJobCorrectly() {

        Ranger ranger = setUpRanger();
        assertTrue(ranger instanceof Ranger);

    }

    @Test
    public void getsNameCorrectly(){
        Ranger ranger = setUpRanger();
        assertEquals("HR", ranger.getRanger());
    }

    @Test
    public void getsBadgeCorrectly(){
        Ranger ranger = setUpRanger();
        assertEquals(547,ranger.getBadge());
    }

    @Test
    public void getsAllRangersCreated(){
        Ranger ranger = setUpRanger();
        assertTrue(Ranger.getAll().contains(ranger));
    }

    public Ranger setUpRanger(){
        return new Ranger("HR",547);
    }



}