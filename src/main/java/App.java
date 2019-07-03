import interfaces.*;
import models.Ranger;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        //To connect to the database
//        String connectIt = "jdbc:h2:~/wildlife.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectIt, "", "");
//        SqlRangerInterface sqlRangerInterface= new SqlRangerInterface(sql2o);
//        SqlAnimalInterface sqlAnimalInterface = new SqlAnimalInterface(sql2o);
//        SqlSpeciesInterface sqlSpeciesInterface = new SqlSpeciesInterface(sql2o);
//        SqlLocationInterface sqlLocationInterface = new SqlLocationInterface(sql2o);
//        SqlSightingsInterface sqlSightingsInterface = new SqlSightingsInterface(sql2o);

        //Get: Display home page
        //Get: Display add info page with tabs for forms
        //Post: Receive data from the Animals form
        //Post: Receive data from the Species form
        //Post: Receive data from the Ranger form
        //Post: Receive data from the Locations form
        //Get: Display the success page
        //Get: Display the Sightings form
        //Post: Receive data from the Sightings form
    }

}
