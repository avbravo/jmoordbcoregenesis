/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcoregenesis.repository;

import com.jmoordbcoregenesis.annotations.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import java.io.Serializable;

/**
 *
 * @author avbravo
 */
@Repository
public abstract class AbstractEntityRepository <E, PK extends Serializable> implements EntityRepository<E, PK>{
 
    /**
     * Utility method to get hold of the entity manager for this Repository.
     *
     * @return          Entity manager instance.
     */
    protected abstract EntityManager getEntityManager();
 
    /**
     * Utility method to create a criteria query.
     * @return          Criteria query
     */
    protected abstract CriteriaQuery<E> getCriteriaQuery();
 
    /**
     * Get the entity class this Repository is related to.
     * @return          Repository entity class.
     */
    protected abstract Class<E> getEntityClass();
 
    
}
