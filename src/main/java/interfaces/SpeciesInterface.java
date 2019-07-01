package interfaces;


import models.Species;

import java.util.List;

public interface SpeciesInterface {
    //Add a location
    void add(Species species);

    //Get all locations
    List<Species> getAll();

    //Find the location
    Species findById(int id);
}
