/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcdi.configuration;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import java.util.Map;

/**
 *Guarda la informacion de la conexion de mongodb
 * que sera indicada desde la aplicacion
 * @author avbravo
 */
public class JmoordbConnection {

    String database;
    String username;
    String password;
    String host;
    Integer port;
    Boolean security;
    private String uri;
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    Map<String, Object> sessionMap = externalContext.getSessionMap();

    public JmoordbConnection() {
    }

    public JmoordbConnection(
            String database,
            String username,
            String password,
            String host,
            Integer port,
            Boolean security,
            String uri) {

        this.database = database;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
        this.security = security;
        this.uri=uri;

        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("database", database);
        sessionMap.put("username", username);
        sessionMap.put("password", password);
        sessionMap.put("host", host);
        sessionMap.put("security", security);
        sessionMap.put("uri", uri);

    }

    /*
    Para que devuelva el del contexto
     */
    public String getUsername() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        String username = (String) sessionMap.get("username");
        return username;
    }
    public String getUri() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        String uri = (String) sessionMap.get("uri");
        return uri;
    }

    public String getPassword() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        String password = (String) sessionMap.get("password");
        return password;
    }

    public String getDatabase() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        String database = (String) sessionMap.get("database");
        return database;
    }

    public String getHost() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        String host = (String) sessionMap.get("host");
        return host;
    }

    public Integer getPort() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        Integer port = (Integer) sessionMap.get("port");
        return port;
    }

    public Boolean getSecurity() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        Boolean security = (Boolean) sessionMap.get("security");
        return security;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setSecurity(Boolean security) {
        this.security = security;
    }

    public ExternalContext getExternalContext() {
        return externalContext;
    }

    public void setExternalContext(ExternalContext externalContext) {
        this.externalContext = externalContext;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public static class Builder {

        String database;
        String username;
        String password;
        String host;
        Integer port;
        Boolean security;
        String uri;

        public Builder withUri(String uri) {
            this.uri = uri;
            return this;
        }
        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withPort(Integer port) {
            this.port = port;
            return this;
        }

        public Builder withHost(String host) {
            this.host = host;
            return this;
        }

        public Builder withDatabase(String database) {
            this.database = database;
            return this;
        }

        public Builder withSecurity(Boolean security) {
            this.security = security;
            return this;
        }

        public JmoordbConnection build() {
            return new JmoordbConnection(
                    database,
                    username,
                    password,
                    host,
                    port,
                    security,
                    uri
            );
        }

    }

}
