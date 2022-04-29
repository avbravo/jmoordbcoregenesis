/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcoregenesis.decorator;

import jakarta.inject.Inject;

/**
 *
 * @author avbravo
 */
//@Decorator
public abstract class RepositoryDecoratorImpl <T, V> implements RepositoryDecotator<T, V>{
//  @Inject @Delegate Repository<T, V> delegate;
    @Inject RepositoryDecotator<T, V> delegate;

//    @Inject Logger log;
//    @Inject Set<Permission> permissions;

    public void save(T object) {
      //  authorize(SecureAction.SAVE, object);
        delegate.save(object);
    }

    public void delete(T object) {
        //authorize(SecureAction.DELETE, object);
        delegate.delete(object);
    }
  public Class<T> getDataType(){
      
        return null;
      
  }
     public V getId(T object){
         
        return null;
         
     }
    public T load(V id){
        
        return null;
        
    }
//    private void authorize(SecureAction action, T object) {
//        V id = delegate.getId(object);
//        Class<T> type = delegate.getDataType();
//        if ( permissions.contains( new Permission(action, type, id) ) ) {
//            log.fine("Authorized for " + action);
//        }
//        else {
//            log.fine("Not authorized for " + action);
//            throw new NotAuthorizedException(action);
//        }
//    }
}
