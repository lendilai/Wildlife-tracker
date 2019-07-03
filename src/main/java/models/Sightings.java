package models;

import interfaces.SqlRangerInterface;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Sightings {
    private String ranger_id;
    private String species_id;
    private String animal_id;
    private String location_id;
    private int id;

    public Sightings(String animal_id, String species_id, String ranger_id, String location_id){
        this.animal_id = animal_id;
        this.species_id = species_id;
        this.ranger_id = ranger_id;
        this.location_id = location_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sightings)) return false;
        Sightings sightings = (Sightings) o;
        return id == sightings.id &&
                getRanger_id().equals(sightings.getRanger_id()) &&
                getSpecies_id().equals(sightings.getSpecies_id()) &&
                getAnimal_id().equals(sightings.getAnimal_id()) &&
                getLocation_id().equals(sightings.getLocation_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRanger_id(), getSpecies_id(), getAnimal_id(), getLocation_id(), id);
    }

    public String getRanger_id() {
        return ranger_id;
    }

    public String getSpecies_id() {
        return species_id;
    }

    public String getAnimal_id() {
        return animal_id;
    }

    public String getLocation_id() {
        return location_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
