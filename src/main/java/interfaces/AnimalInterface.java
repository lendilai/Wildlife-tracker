package interfaces;

import models.Animal;

import java.util.List;

public interface AnimalInterface {
    //Add an animal
    void add(Animal animal);

    //Get all animals
    List<Animal> getAll();
//
//    //Fetch an animal
//    Animal findById(int id);
}
