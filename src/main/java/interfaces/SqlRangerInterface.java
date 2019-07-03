package interfaces;

import models.Ranger;
import org.sql2o.*;
import org.sql2o.Sql2oException;


import java.util.List;


public class SqlRangerInterface implements RangerInterface {
    private final Sql2o sql2o;

    public SqlRangerInterface(Sql2o sql2o){
        this.sql2o = sql2o;

    }

    @Override
    public void add(Ranger ranger) {
        String sql = "INSERT INTO  rangers(ranger,badge) VALUES (:ranger,:badge)";
        try (Connection con = sql2o.open()){
           int id =(int) con.createQuery(sql,true).bind(ranger).executeUpdate().getKey();
           ranger.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Ranger> getAll() {
        String sql = "SELECT * FROM rangers";
        try(Connection conn = sql2o.open()){
           return conn.createQuery(sql).executeAndFetch(Ranger.class);
        }
    }

    @Override
    public Ranger findById(int id) {
        String sql = "SELECT * FROM  rangers WHERE id=:id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Ranger.class);
        }
    }

    @Override
    public void delete(int id){
        String sql = "DELETE from rangers WHERE id=:id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql).addParameter("id", id).executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllRangers(){
        String sql = "DELETE from rangers";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql).executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
