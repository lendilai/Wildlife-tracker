package models;

public class Animal extends AnimalsGen{
    private boolean endangered;

    public Animal(String the_name, boolean endangered){
        this.the_name = the_name;
        this.endangered = endangered;
        this.id = 1;
    }

    public boolean isEndangered() {
        return endangered;
    }
}
