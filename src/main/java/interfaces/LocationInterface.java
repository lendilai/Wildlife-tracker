package interfaces;

import models.Location;
import models.Sightings;

import java.util.List;

public interface LocationInterface {
    //Add a location
    void add(Location location);

    //Get all locations
    List<Location> getAll();

    //Find the location
    Location findById(int id);

    //Clear
    void clearAllLocations();

}
