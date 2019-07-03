import interfaces.*;
import models.Animal;
import models.Location;
import models.Ranger;
import models.Species;
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
        String connectIt = "jdbc:h2:~/wildlife.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectIt, "", "");
        SqlRangerInterface sqlRangerInterface= new SqlRangerInterface(sql2o);
        SqlAnimalInterface sqlAnimalInterface = new SqlAnimalInterface(sql2o);
        SqlSpeciesInterface sqlSpeciesInterface = new SqlSpeciesInterface(sql2o);
        SqlLocationInterface sqlLocationInterface = new SqlLocationInterface(sql2o);
        SqlSightingsInterface sqlSightingsInterface = new SqlSightingsInterface(sql2o);

        //Get: Display home page
        get("/", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            return new ModelAndView(user, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //Get: Display add info page with tabs for forms
        get("/info", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            return new ModelAndView(user, "info.hbs");
        }, new HandlebarsTemplateEngine());

        //Post: Receive data from the Animals form
        post("/info/animal/new", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            String theName = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            Boolean endangered = Boolean.parseBoolean(request.queryParams("boolean"));
            Animal newAnimal = new Animal(theName, health, age, endangered);
            sqlAnimalInterface.add(newAnimal);
            return new ModelAndView(user, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //Post: Receive data from the Species form
        post("/info/species/new", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            String species = request.queryParams("species");
            Species newSpecies = new Species(species);
            sqlSpeciesInterface.add(newSpecies);
            return new ModelAndView(user, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //Post: Receive data from the Ranger form
        post("/info/ranger/new", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            String rangerName = request.queryParams("ranger");
            int badgeNo = Integer.parseInt(request.queryParams("badge"));
            Ranger newRanger = new Ranger(rangerName, badgeNo);
            sqlRangerInterface.add(newRanger);
            return new ModelAndView(user, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //Post: Receive data from the Locations form
        post("/info/location/new", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            String theLocation = request.queryParams("location");
            Location newLocation = new Location(theLocation);
            sqlLocationInterface.add(newLocation);
            return new ModelAndView(user, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //Get: Display the Sightings form
        //Post: Receive data from the Sightings form
    }

}
