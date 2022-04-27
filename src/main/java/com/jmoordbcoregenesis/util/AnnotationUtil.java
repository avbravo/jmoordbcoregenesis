/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcoregenesis.util;

import com.avbravo.jmoordbcdi.annotations.Referenced;
import com.jmoordbcoregenesis.annotations.Embedded;
import com.jmoordbcoregenesis.annotations.Query;
import com.jmoordbcoregenesis.annotations.entity.Id;
import static com.jmoordbcoregenesis.util.ClassUtil.logger;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * Lee las anotraciones y devuelve los valores como un Pojo
 *
 * @author avbravo
 */
public class AnnotationUtil {

    // <editor-fold defaultstate="collapsed" desc="Optional<Query> queryAnnotationReader(Class classa, String method   )">
    /**
     *
     * @param classa : Clase a analizar
     * @param method : metodo que deseamos encontrar
     * @return Query : anotacion de la cual podemos leer los valores
     */
    public static Optional<Query> queryAnnotationReader(Class classa, String method) {
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
            logger.log(Level.SEVERE, ClassUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" List<String> embeddedFields(Class classa )">
    /**
     * Devuele la lista de campos con el atributo @Embedded
     *
     * @param classa : Clase a analizar
     * @param method : metodo que deseamos encontrar
     * @return Query : anotacion de la cual podemos leer los valores
     */
    public static List<String> embeddedFields(Class classa) {
        List<String> fields = new ArrayList<>();
        try {

            fields
                    = Arrays.asList(classa.getFields())
                            .stream()
                            .filter(f -> f.getAnnotation(Embedded.class) != null)
                            .map(f -> f.getAnnotation(Embedded.class).name())
                            .collect(Collectors.toList());

        } catch (Exception e) {

            logger.log(Level.SEVERE, ClassUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return fields;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<String> fieldWithEmbeddedAnnotation(Class classa)">
    /**
     * Devuele la lista de campos con el atributo @Embedded
     *
     * @param classa : Clase a analizar
     * @param method : metodo que deseamos encontrar
     * @return Query : anotacion de la cual podemos leer los valores
     */
    public static List<String> fieldWithEmbeddedAnnotation(Class classa) {
        List<String> fields = new ArrayList<>();
        try {
            fields = Arrays.asList(classa.getFields())
                    .stream()
                    .filter(f -> f.getAnnotation(Embedded.class) != null)
                    .map(f -> f.getAnnotation(Embedded.class).name())
                    .collect(Collectors.toList());

        } catch (Exception e) {

            logger.log(Level.SEVERE, ClassUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return fields;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<String> fieldWithIdAnnotation(Class classa) ">
    /**
     * Devuele la lista de campos con el atributo @Id
     *
     * @param classa : Clase a analizar
     * @param method : metodo que deseamos encontrar
     * @return Query : anotacion de la cual podemos leer los valores
     */
    public static List<String> fieldWithIdAnnotation(Class classa) {
        List<String> fields = new ArrayList<>();
        try {
            System.out.println(">>> voy a procesar la anotacion  @Id");
            Annotation[] annotations = classa.getAnnotations();
            if (annotations == null || annotations.length == 0) {
                System.out.println(">>> NO SE ENCONTRO ANOTACIONES");
            } else {
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Id) {
                        Id idValue = (Id) annotation;
                        System.out.println(">>>>>>>> Annotation for idValue.field()" + idValue.field());
                        // fields.add(((Id) annotation).field());

                    } else {
                        System.out.println(">>>>>>>  No es instancia de Id");
                    }
                }

            }

            fields = Arrays.asList(classa.getFields())
                    .stream()
                    .filter(f -> f.getAnnotation(Id.class) != null)
                    .map(f -> f.getAnnotation(Id.class).field())
                    .collect(Collectors.toList());

        } catch (Exception e) {

            logger.log(Level.SEVERE, ClassUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return fields;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<String> fieldWithReferencedAnnotation(Class classa)">
    /**
     * Devuele la lista de campos con el atributo @Embedded
     *
     * @param classa : Clase a analizar
     * @param method : metodo que deseamos encontrar
     * @return Query : anotacion de la cual podemos leer los valores
     */
    public static List<String> fieldWithReferencedAnnotation(Class classa) {
        List<String> fields = new ArrayList<>();
        try {
            fields = Arrays.asList(classa.getFields())
                    .stream()
                    .filter(f -> f.getAnnotation(Referenced.class) != null)
                    .map(f -> f.getAnnotation(Referenced.class).field())
                    .collect(Collectors.toList());

        } catch (Exception e) {

            logger.log(Level.SEVERE, ClassUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return fields;
    }
    // </editor-fold>

}
