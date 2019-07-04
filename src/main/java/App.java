import interfaces.*;
import models.*;
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
        String connectIt = "jdbc:postgresql://localhost:5432/wildlife_tracker";
        Sql2o sql2o = new Sql2o(connectIt, "rlgriff", "547");
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
            Boolean endangered = Boolean.parseBoolean(request.queryParams("boolean"));
            Animal newAnimal = new Animal(theName, endangered);
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
        get("/sightings/new", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            user.put("animals", sqlAnimalInterface.getAll());
            user.put("species", sqlSpeciesInterface.getAll());
            user.put("locations", sqlLocationInterface.getAll());
            user.put("rangers", sqlRangerInterface.getAll());
            user.put("ageInfo1", Sightings.getADULT());
            user.put("ageInfo2", Sightings.getYOUNG());
            user.put("ageInfo3", Sightings.getNewBorn());
            user.put("healthInfo1", Sightings.getHEALTHY());
            user.put("healthInfo2", Sightings.getOKAY());
            user.put("healthInfo3", Sightings.getILL());
            return new ModelAndView(user, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //Post: Receive data from the Sightings form
        post("/sightings/new", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            String animal = request.queryParams("animal");
            String specie = request.queryParams("specie");
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            Sightings newSighting = new Sightings(animal, specie, ranger, location, age, health);
            sqlSightingsInterface.addSighting(newSighting);
            user.put("sighting", newSighting);
            return new ModelAndView(user, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //Get: View all sightings made
        get("/sightings", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            user.put("allSightings", sqlSightingsInterface.getAllSightings());
            return new ModelAndView(user, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //Get: View all locations
        get("/locations", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            user.put("allLocations", sqlLocationInterface.getAll());
            return new ModelAndView(user, "locations.hbs");
        }, new HandlebarsTemplateEngine());

        //Get: To filter the sightings by most recent
        get("/sightings/most-recent", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            user.put("filterSightings", sqlSightingsInterface.filterSightings());
            return new ModelAndView(user, "sightings-filtered.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
