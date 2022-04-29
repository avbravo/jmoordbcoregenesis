/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcoregenesis.producer.mongodb;

import com.jmoordbcoregenesis.util.ClassUtil;
import com.jmoordbcoregenesis.util.FacesMessagesUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author avbravo
 */
//@Singleton
//@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@ApplicationScoped
//@Stateless
public class MongoClientManagerProducer {
private static final Logger LOG = LoggerFactory.getLogger(MongoClientManagerProducer.class);
//@ApplicationScoped
    @Produces
    public MongoClient mongoClient() {
        String uri = "mongodb://localhost:27017";
 System.out.println("---> paso 0");
//            String uri = "<connection string uri>";
//        MongoClient mongo;
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
          

//        MongoClient mongo = new MongoClient("localhost", 27017);
//        try {
//            String uri = JmoordbContext.get("uri") == null ? "" : (String) JmoordbContext.get("uri");
//            if (uri == null || uri.isEmpty()) {
//                String username = JmoordbContext.get("username") == null ? "" : (String) JmoordbContext.get("username");
//                String password = JmoordbContext.get("password") == null ? "" : (String) JmoordbContext.get("password");
//                String database = JmoordbContext.get("database") == null ? "" : (String) JmoordbContext.get("database");
//                String host = JmoordbContext.get("host") == null ? "" : (String) JmoordbContext.get("host");
//                String port = JmoordbContext.get("port") == null ? "" : (String) JmoordbContext.get("port");
//                Boolean security = JmoordbContext.get("security") == null ? false : (Boolean) JmoordbContext.get("security");
//                if (security == null && username == null) {
//                    security = false;
//                }
//                if (security) {
//
//                    char[] charArray = password.toCharArray();
//                    MongoCredential credential = MongoCredential.createCredential(username, database, charArray);
//                    ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(port));
////             mongo = new MongoClient(serverAddress, new ArrayList<>());
//
//                    mongo = new MongoClient(serverAddress, new ArrayList<MongoCredential>() {
//                        {
//                            add(credential);
//                        }
//                    });
////           
//                } else {
//                    mongo = new MongoClient();
//                }
//            } else {
//                System.out.println("--->conectacndose a MongoDB Atlas");
//                //Para conexion por uri generalmente de MongoDB Atlas
//                mongo = new MongoClient(new MongoClientURI(uri));
//            }
 System.out.println("---> paso 1");
            return mongoClient;
        } catch (Exception e) {
             LOG.error(e.getLocalizedMessage());
            FacesMessagesUtil.showInfo(e.getLocalizedMessage(), ClassUtil.nameOfClassAndMethod());
            System.out.println("error() " + e.getLocalizedMessage());
            //       JmoordbUtil.errorMessage("conecction() "+e.getLocalizedMessage());
        }

      return MongoClients.create();
//      return null;
    }

//    @Produces
//    public MongoDatabase createDB(MongoClient client) {
//        return client.getDatabase("testdb");
//    }
//    public void close(@Disposes MongoClient toClose) {
//        toClose.close();
//    }
}
