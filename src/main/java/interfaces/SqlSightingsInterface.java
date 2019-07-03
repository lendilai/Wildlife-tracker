package interfaces;

import models.Sightings;
import org.sql2o.*;

import java.util.List;

public class SqlSightingsInterface implements SightingsInterface{
    private final Sql2o sql2o;

    public SqlSightingsInterface(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void addSighting(Sightings sightings){
        String sql = "INSERT INTO sightings (ranger_id, species_id, animal_id, location_id) VALUES (:ranger_id, :species_id, :animal_id, :location_id)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql, true).bind(sightings).executeUpdate().getKey();
            sightings.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Sightings> getAllSightings(){
        String sql = "SELECT * FROM sightings";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }

    @Override
    public List<Sightings> filterSightings(){
        String sql = "SELECT * FROM sightings ORDER BY id DESC";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }


    @Override
    public Sightings findSighting(int id){
        String sql = "SELECT * FROM sightings WHERE id=:id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Sightings.class);
        }
    }
    public void clearAllSightings(){
        String sql = "DELETE FROM sightings";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql).executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
