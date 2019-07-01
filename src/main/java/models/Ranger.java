package models;

import java.util.ArrayList;
import java.util.Objects;

public class Ranger {

    private String ranger;
    private int  badge;
    private int id;
    private static ArrayList<Ranger> rangers = new ArrayList<>();



    public Ranger(String ranger, int badge){

        this.ranger=ranger;
        this.badge=badge;
        this.rangers.add(this);
        this.id = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ranger)) return false;
        Ranger ranger1 = (Ranger) o;
        return getBadge() == ranger1.getBadge() &&
                getId() == ranger1.getId() &&
                getRanger().equals(ranger1.getRanger());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRanger(), getBadge(), getId());
    }

    public static ArrayList<Ranger> getAll() {
        return rangers;
    }

    public String getRanger() {
        return ranger;
    }

    public int getBadge() {
        return badge;
    }
    public  int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
