/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcoregenesis.decorator;

/**
 *
 * @author avbravo
 */
public interface RepositoryDecotator<T, V> {

    public V getId(T object);

    public T load(V id);

    public void save(T object);

    public void delete(T object);

    public Class<T> getDataType();
}
