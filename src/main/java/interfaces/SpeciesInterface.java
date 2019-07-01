package interfaces;


import models.Species;

import java.util.List;

public interface SpeciesInterface {
    //Add a specie
    void add(Species species);

    //Get all species
    List<Species> getAll();

    //Find a specie
    Species findById(int id);
}
