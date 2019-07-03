package models;

public class Animal extends AnimalsGen{
    private String health;
    private String age;
    private boolean endangered;

    public Animal(String the_name, String health, String age, boolean endangered){
        this.the_name = the_name;
        this.health = health;
        this.age = age;
        this.endangered = endangered;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public boolean isEndangered() {
        return endangered;
    }
}
