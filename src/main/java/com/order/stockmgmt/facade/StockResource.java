/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.stockmgmt.facade;



import com.order.stockmgmt.domaine.Component;
import com.order.stockmgmt.domaine.Order;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Numalama
 */
@Path("date")
@RequestScoped
public class StockResource {
    
    @EJB
    private OrderingServiceRemote orderingService;

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String restMsg = "{\"message\":\"hello REST\"}";
        return restMsg;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response purchaseOrder(Order order) {
        //affichage du corps de la requête POST.
        
        String content = new String();
        System.out.println(content);
        //retour d'une réponse sans corps indiquant un statut 202 : la requête a été acceptée mais le processus n'est pas terminé

        StringReader reader = new StringReader(content);
        Order o = new Order();
        try (JsonReader jreader = Json.createReader(reader)) {
            //Order infos
            JsonObject orderInfo = jreader.readObject();
            Long test = orderInfo.getJsonNumber("id").longValue();
            o.setName(orderInfo.getString("name"));
            JsonObject componentInfo = orderInfo.getJsonObject("components");
            // Component Infos
            Component c = new Component();
            c.setId(Long.parseLong(componentInfo.getString("id")));
            c.setName(componentInfo.getString("name"));
            c.setQty(Long.parseLong(componentInfo.getString("qty")));

            Set<Component> components = new HashSet<Component>();
            components.add(c);
            o.setComponents(components);

        }
        Boolean isValid = orderingService.checkOrder(o.getId(), o.getName(), o.getComponents());

        Response resp = null;
        if (isValid) {
            resp = Response.accepted().build();
        } else {
            resp = Response.status(400).entity("n° CB invalide").build();
        }
        return resp;
    }
    
    
    @Path("orders")
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getStoredOrders(){
        // récupération de tous  les bons de commandes stockés
        
        List<Order> storedOrders = orderingService.lookupAllStoredOrders();
        //création d'une entité générique pour pouvoir mapper un type 
        //(Set<Order>) avec  un corps de réponse
        GenericEntity<List<Order>> genericList = new   GenericEntity<List<Order>>(storedOrders){};
        //construction de la réponse embarquant dans son corps les ordres de paiements
        Response resp = Response.ok(genericList).build();
        return resp; 
        
       
    }

}
