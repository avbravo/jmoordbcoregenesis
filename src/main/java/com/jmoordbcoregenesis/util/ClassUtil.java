/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcoregenesis.util;

import com.jmoordbcoregenesis.annotations.Query;
import jakarta.inject.Inject;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author avbravo
 */
public class ClassUtil {
    // <editor-fold defaultstate="collapsed" desc="methods()">
 static   Logger logger = Logger.getLogger(ClassUtil.class.getName());
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="nameOfMethod(">
    public static String nameOfMethod() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return e.getMethodName();
    }
    // </editor-fold>
    
      // <editor-fold defaultstate="collapsed" desc="nameOfClassAndMethod()">
    public static String nameOfClassAndMethod() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length()) + "." + e.getMethodName();
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="nameOfClass()">

    public static String nameOfClass() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length());
    }    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Optional<Query> readQueryAnnotation(Class classa, String method   )">
    /**
     * 
     * @param classa : Clase a analizar
     * @param method : metodo que deseamos encontrar
     * @return Query : anotacion de la cual podemos leer los valores
     */
    
    public static Optional<Query> readQueryAnnotation(Class classa, String method   ){
        Query query;
        try {            
             Method[] methods = classa.getMethods();
            for (Method m : methods) {
                if (m.getName().equals(method)) {

                    if (m.isAnnotationPresent(Query.class)) {

                        query = m.getAnnotation(Query.class);

                        return Optional.of(query);
                    }
                }
            }

        } catch (Exception e) {
             //FacesMessagesUtil.showError(e.getLocalizedMessage(), ClassUtil.nameOfClassAndMethod());
              logger.log(Level.SEVERE,  ClassUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }
        return Optional.empty();
    }
    // </editor-fold>
}
