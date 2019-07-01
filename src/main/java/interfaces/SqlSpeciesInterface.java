package interfaces;

import models.Species;
import org.sql2o.*;

import java.util.List;

public class SqlSpeciesInterface implements SpeciesInterface{
    private final Sql2o sql2o;

    public SqlSpeciesInterface(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Species species){
        String sql = "INSERT INTO species(the_name) VALUES (:the_name)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql, true).bind(species).executeUpdate().getKey();
            species.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Species> getAll(){
        String sql = "SELECT * FROM species";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Species.class);
        }
    }

    @Override
    public Species findById(int id){
        String sql = "SELECT * FROM species WHERE id=:id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Species.class);
        }
    }
}
