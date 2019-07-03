package interfaces;

import models.Animal;
import org.sql2o.*;

import java.util.List;

public class SqlAnimalInterface implements AnimalInterface{
    private final Sql2o sql2o;

    public SqlAnimalInterface(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Animal animal){
        String sql = "INSERT INTO animals(the_name, health, age, endangered) VALUES (:the_name,:health,:age,:endangered)";
        try(Connection conn =sql2o.open()){
            int id = (int) conn.createQuery(sql, true).bind(animal).executeUpdate().getKey();
            animal.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Animal> getAll(){
        String sql = "SELECT * FROM animals";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Animal.class);
        }
    }

    @Override
    public Animal findById(int id){
        String sql = "SELECT * FROM animals WHERE id=:id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Animal.class);
        }
    }

    @Override
    public void clearAllAnimals(){
        String sql = "DELETE from animals";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql).executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
