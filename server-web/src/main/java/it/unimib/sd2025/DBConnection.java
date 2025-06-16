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
import java.util.Scanner;
import java.net.Socket;


// manage connection with the database
public class DBConnection{

    private final String address = "127.0.0.1";
    private final int port = 3030;

   // non serve il costruttore senza parametri (? ereditato da OBJ ?)

   public String sendMessage(String message){

    try(var socket = new Socket(address, port);
        Scanner scanner = new Scanner(socket.getInputStream())) {

            // invio il messaggio
            var output = socket.getOutputStream();
            output.write(message.getBytes());

            // aspetto risposta del db
            String response = scanner.nextLine();
            return response;
        }catch (Exception ex) {
          return null;
        }
        
   }

    // gestisce la risposta ad una GET
    public Response manageGet(String message){
        if(message.equals("NOT_FOUND")){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // la conversione da stringa ad oggetto json viene fatta automaticamente
        return Response.ok(message).build();
   }
}