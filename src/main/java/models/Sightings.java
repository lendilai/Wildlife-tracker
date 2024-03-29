package models;

import interfaces.SqlRangerInterface;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Sightings {
    private String ranger_id;
    private String species_id;
    private String animal_id;
    private String location_id;
    private String health;
    private String age;
    private String url;
    public static final String HEALTHY = "Healthy";
    public static final String ILL = "ill";
    public static final String OKAY = "Okay";
    public static final String NEW_BORN = "Newborn";
    public static final String YOUNG = "Young";
    public static final String ADULT = "Adult";
    private int id;
    private Timestamp sighted_on;

    public Sightings(String animal_id, String species_id, String ranger_id, String location_id, String health, String age, String url){
        this.animal_id = animal_id;
        this.species_id = species_id;
        this.ranger_id = ranger_id;
        this.location_id = location_id;
        this.health = health;
        this.age = age;
        this.url = url;
        this.sighted_on = new Timestamp(new Date().getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sightings)) return false;
        Sightings sightings = (Sightings) o;
        return getId() == sightings.getId() &&
                getRanger_id().equals(sightings.getRanger_id()) &&
                getSpecies_id().equals(sightings.getSpecies_id()) &&
                getAnimal_id().equals(sightings.getAnimal_id()) &&
                getLocation_id().equals(sightings.getLocation_id()) &&
                getHealth().equals(sightings.getHealth()) &&
                getAge().equals(sightings.getAge()) &&
                getUrl().equals(sightings.getUrl()) &&
                getSighted_on().equals(sightings.getSighted_on());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRanger_id(), getSpecies_id(), getAnimal_id(), getLocation_id(), getHealth(), getAge(), getUrl(), getId(), getSighted_on());
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

    public String getHealth() {
        return health;
    }

    public static String getHEALTHY() {
        return HEALTHY;
    }

    public static String getILL() {
        return ILL;
    }

    public static String getOKAY() {
        return OKAY;
    }

    public static String getNewBorn() {
        return NEW_BORN;
    }

    public static String getYOUNG() {
        return YOUNG;
    }

    public static String getADULT() {
        return ADULT;
    }

    public String getAge() {
        return age;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getSighted_on() {
        return sighted_on;
    }
}
