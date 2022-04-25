/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.jmoordbcoregenesis.document;

import org.bson.Document;

/**
 *
 * @author avbravo
 */
public interface DocumentUtils {
     public  <T> Document toDocument(T obj) throws Exception;
     public  <T> T toObject(Document doc, Class<T> clazz) throws Exception;
}
