package controllers;

import play.mvc.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import javax.inject.Inject;
import org.mongodb.morphia.Datastore;
import javax.inject.Singleton;
import models.addDataModel;
import play.mvc.Result;
import org.mongodb.morphia.Key;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Singleton
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

/*
@Inject
public HomeController(Datastore dataStore){
    this.dataStore = dataStore;*/
@Inject
    Datastore dataStore;

    public Result index() {
        return ok();
    }

    public Result welcomeUser(){
        ObjectNode objectNode = Json.newObject();
       objectNode.put("Name","My Name");
       return ok(Json.toJson(objectNode));
    }

    public Result addData() {
           JsonNode request = request().body().asJson();
           addDataModel b = Json.fromJson(request,addDataModel.class);
            // addDataModel b= new addDataModel();
            // b.setProdName("hRLLO");
           Key<addDataModel> keys = dataStore.save(b);
        return ok(Json.toJson(keys));
    }


}
