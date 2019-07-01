package models;

import java.util.Objects;

public abstract class AnimalsGen {
    public String the_name;
    public int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnimalsGen)) return false;
        AnimalsGen that = (AnimalsGen) o;
        return getId() == that.getId() &&
                getThe_name().equals(that.getThe_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getThe_name(), getId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThe_name() {
        return the_name;
    }
}
