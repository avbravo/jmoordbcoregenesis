/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcoregenesis.annotations;

import jakarta.persistence.LockModeType;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.List;

/**
 *
 * @author avbravo
 */
public interface QueryResult <E>
{
 
    /**
     * Sort the query result ascending by the given entity singular attribute.
     * This is the typesafe version, alternatively a {@link #orderAsc(String)}
     * String can be used.
     *
     * @param attribute         Sort attribute.
     * @return                  Fluent API: the result instance.
     */
    <X> QueryResult<E> orderAsc(SingularAttribute<E, X> attribute);
 
    /**
     * Sort the query result ascending by the given entity attribute.
     *
     * @param attribute         Sort attribute.
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> orderAsc(String attribute);
 
    /**
     * Sort the query result descending by the given entity singular attribute.
     * This is the typesafe version, alternatively a {@link #orderDesc(String)}
     * String can be used.
     *
     * @param attribute         Sort attribute.
     * @return                  Fluent API: the result instance.
     */
    <X> QueryResult<E> orderDesc(SingularAttribute<E, X> attribute);
 
    /**
     * Sort the query result descending by the given entity attribute.
     *
     * @param attribute         Sort attribute.
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> orderDesc(String attribute);
 
    /**
     * Revert an existing order attribute sort direction. Defaults to ascending
     * order if the sort attribute was not used before.
     *
     * @param attribute         Sort attribute.
     * @return                  Fluent API: the result instance.
     */
    <X> QueryResult<E> changeOrder(SingularAttribute<E, X> attribute);
 
    /**
     * Remove any ordering from the query result object.
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> clearOrder();
 
    /**
     * Revert an existing order attribute sort direction. Defaults to ascending
     * order if the sort attribute was not used before.
     *
     * @param attribute         Sort attribute.
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> changeOrder(String attribute);
 
    /**
     * Limit the number of results returned by the query.
     *
     * @param max               Max number of results.
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> maxResults(int max);
 
    /**
     * Pagination: Set the result start position. 0-based (as the JPA Query API).
     *
     * @param first             Result start position.
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> firstResult(int first);
 
    /**
     * Sets the query lock mode.
     *
     * @param lockMode          Query lock mode to use in the query.
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> lockMode(LockModeType lockMode);
 
    /**
     * Apply a query hint to the query to execute.
     *
     * @param hint              Hint name.
     * @param value             Hint value.
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> hint(String hint, Object value);
 
    /**
     * Fetch the result set.
     *
     * @return                  List of entities retrieved by the query.
     */
    List<E> getResultList();
 
    /**
     * Fetch a single result entity.
     *
     * @return                  Entity retrieved by the query.
     */
    E getSingleResult();
 
    /**
     * Count the result set.
     * @return                  Result count.
     */
    long count();
 
    /**
     * Turns the query into a paged query with the given page size.
     * Defaults to 10 if paging methods are called without this.
     *
     * @param pageSize          Page size for further queries.
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> withPageSize(int pageSize);
 
    /**
     * Move the page cursor to a specific page. First page is page 0.
     *
     * @param page              Page to move to for the next query.
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> toPage(int page);
 
    /**
     * Move to the next page.
     *
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> nextPage();
 
    /**
     * Move to the previous page.
     *
     * @return                  Fluent API: the result instance.
     */
    QueryResult<E> previousPage();
 
    /**
     * Count the number of pages.
     * @return                  Page count.
     */
    int countPages();
 
    /**
     * Return the actual page.
     * @return                  Page position.
     */
    int getCurrentPage();
 
    /**
     * Return the actual page size.
     * @return                  Page size.
     */
    int getPageSize();
 
    
}
