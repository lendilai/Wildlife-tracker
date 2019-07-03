package interfaces;

import models.Ranger;

import java.util.List;

public interface RangerInterface {
    //create a list
    void add(Ranger ranger);

    List<Ranger> getAll();

    //find specific job
    Ranger findById(int id);

    //delete
    void delete(int id);
    void clearAllRangers();
}
