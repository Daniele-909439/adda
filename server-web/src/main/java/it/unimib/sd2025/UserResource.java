package it.unimib.sd2025;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import jakarta.json.JsonException;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * Rappresenta la risorsa "example" in "http://localhost:8080/example".
 */
@Path("users")
public class UserResource {
    private static DBConnection connection;

    // Inizializzazione statica.
    static {
       // inializzazione statica 
    }

   // Restituisce un utente dato il suo id
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserId(@PathParam("id") String id) {

        connection = new DBConnection();
        String message = "GET " + id;
        String response = connection.sendMessage(message);
        return connection.manageGet(response);
    }

    /* modificherei líd dellútente per essere una stringa */
    @Path("/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        if(user.getId().equals(null)){
            return Response.status(Status.BAD_REQUEST).build();
        }

        var jsonb = JsonbBuilder.create();
        String usr = null;
        try {
            usr = jsonb.toJson(user, User.class);
            
        } catch (JsonbException e) {
                return Response.status(Status.BAD_REQUEST).build();
        }

        System.out.println(usr);
        connection = new DBConnection();
        String message = "SET " + user.getId() + " " + usr;
        String response = connection.sendMessage(message);

        return Response.ok(response).build();
    }
}