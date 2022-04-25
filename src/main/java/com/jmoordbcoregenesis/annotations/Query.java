/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcoregenesis.annotations;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author avbravo
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Query {
    /**
     * Defines the Query to execute. Can be left empty for method expression queries
     * or when referencing a {@link #named()} query.
     */
    String value() default "";
 
    /**
     * References a named query.
     */
    String named() default "";
 
    /**
     * Flag indicating a native SQL query.
     */
    boolean isNative() default false;
 
    /**
     * Limits the number of results the query returns.
     */
    int max() default 0;
 
    /**
     * Defines a lock mode for the query.
     */
    LockModeType lockMode() default LockModeType.NONE;
 
    /**
     * (Optional) Query properties and hints.  May include vendor-specific query hints.
     */
    QueryHint[] hints() default {
    };
}
