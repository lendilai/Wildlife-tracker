package models;

import java.util.ArrayList;
import java.util.Objects;

public class Location {
    private String location;
    private int id;

    public Location(String location){
        this.location = location;
        this.id = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location1 = (Location) o;
        return getId() == location1.getId() &&
                getLocation().equals(location1.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation(), getId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }
}
