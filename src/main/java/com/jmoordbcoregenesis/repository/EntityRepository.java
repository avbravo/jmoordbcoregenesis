/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcoregenesis.repository;

import jakarta.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author avbravo
 */
public interface EntityRepository<E, PK extends Serializable>
{
 
    /**
     * Persist (new entity) or merge the given entity.
     * @param entity            Entity to save.
     * @return                  Returns the modified entity.
     */
    E save(E entity);
 
    /**
     * {@link #save(Object)}s the given entity and flushes the persistence context afterwards.
     * @param entity            Entity to save.
     * @return                  Returns the modified entity.
     */
    E saveAndFlush(E entity);
 
    /**
     * {@link #save(Object)}s the given entity and flushes the persistence context afterwards,
     * followed by a refresh (e.g. to load DB trigger modifications).
     * @param entity            Entity to save.
     * @return                  Returns the modified entity.
     */
    E saveAndFlushAndRefresh(E entity);
 
    /**
     * Convenience access to {@link javax.persistence.EntityManager#remove(Object)}.
     * @param entity            Entity to remove.
     */
    void remove(E entity);
 
    /**
     * Convenience access to {@link javax.persistence.EntityManager#remove(Object)}
     * with a following flush.
     * @param entity            Entity to remove.
     */
    void removeAndFlush(E entity);
 
    /**
     * Convenience access to {@link javax.persistence.EntityManager#refresh(Object)}.
     * @param entity            Entity to refresh.
     */
    void refresh(E entity);
 
    /**
     * Convenience access to {@link javax.persistence.EntityManager#flush()}.
     */
    void flush();
 
    /**
     * Entity lookup by primary key. Convenicence method around
     * {@link javax.persistence.EntityManager#find(Class, Object)}.
     * @param primaryKey        DB primary key.
     * @return                  Entity identified by primary or null if it does not exist.
     */
    E findBy(PK primaryKey);
 
    /**
     * Lookup all existing entities of entity class {@code <E>}.
     * @return                  List of entities, empty if none found.
     */
    List<E> findAll();
 
    /**
     * Lookup a range of existing entities of entity class {@code <E>} with support for pagination.
     * @param start             The starting position.
     * @param max               The maximum number of results to return
     * @return                  List of entities, empty if none found.
     */
    List<E> findAll(int start, int max);
 
    /**
     * Query by example - for a given object and a specific set of properties.
     * @param example           Sample entity. Query all like.
     * @param attributes        Which attributes to consider for the query.
     * @return                  List of entities matching the example, or empty if none found.
     */
    List<E> findBy(E example, SingularAttribute<E, ?>... attributes);
 
    /**
     * Query by example - for a given object and a specific set of properties with support for pagination.
     * @param example           Sample entity. Query all like.
     * @param start             The starting position.
     * @param max               The maximum number of results to return
     * @param attributes        Which attributes to consider for the query.
     * @return                  List of entities matching the example, or empty if none found.
     */
    List<E> findBy(E example, int start, int max, SingularAttribute<E, ?>... attributes);
 
    /**
     * Query by example - for a given object and a specific set of properties using a like operator for Strings.
     * @param example           Sample entity. Query all like.
     * @param attributes        Which attributes to consider for the query.
     * @return                  List of entities matching the example, or empty if none found.
     */
    List<E> findByLike(E example, SingularAttribute<E, ?>... attributes);
 
    /**
     * Query by example - for a given object and a specific set of properties
     * using a like operator for Strings with support for pagination.
     * @param example           Sample entity. Query all like.
     * @param start             The starting position.
     * @param max               The maximum number of results to return
     * @param attributes        Which attributes to consider for the query.
     * @return                  List of entities matching the example, or empty if none found.
     */
    List<E> findByLike(E example, int start, int max, SingularAttribute<E, ?>... attributes);
 
    /**
     * Count all existing entities of entity class {@code <E>}.
     * @return                  Counter.
     */
    Long count();
 
    /**
     * Count existing entities of entity class {@code <E>}
     * with for a given object and a specific set of properties..
     * @param example           Sample entity. Query all like.
     * @param attributes        Which attributes to consider for the query.
     *
     * @return                  Counter.
     */
    Long count(E example, SingularAttribute<E, ?>... attributes);
 
    /**
     * Count existing entities of entity class using the like operator for String attributes {@code <E>}
     * with for a given object and a specific set of properties..
     * @param example           Sample entity. Query all like.
     * @param attributes        Which attributes to consider for the query.
     *
     * @return                  Counter.
     */
    Long countLike(E example, SingularAttribute<E, ?>... attributes);
 
}