/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcoregenesis.producer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Produces;

/**
 *
 * @author avbravo
 */
public class EntityManagerProducer {
    @PersistenceContext
    private EntityManager em;
 
    @Produces
    public EntityManager expose()
    {
        return em;
    }
}
