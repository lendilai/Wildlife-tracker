package interfaces;

import models.Location;
import org.sql2o.*;

public class SqlLocationInterface implements LocationInterface{
    private final Sql2o sql2o;

    public SqlLocationInterface(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Location location){
        String sql = "INSERT INTO locations(location) VALUES (:location)";
        try(Connection conn = sql2o.open()){
           int id = (int) conn.createQuery(sql,true).bind(location).executeUpdate().getKey();
           location.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
