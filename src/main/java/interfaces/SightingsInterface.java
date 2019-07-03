package interfaces;

import models.Sightings;

import java.util.List;

public interface SightingsInterface {
    //Add a sighting
    void addSighting(Sightings sightings);

    //Find all
    List<Sightings> getAllSightings();

    //Find a single one
    Sightings findSighting(int id);

    //Filter to show from most recent
    List<Sightings> filterSightings();
}
