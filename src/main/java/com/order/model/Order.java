/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.model;

import java.util.Set;

/**
 *
 * @author Numalama
 */
public class Order {
     private Long id;
    
    //private OrderStatus status;
    
    private String name;
    
    private Set<Component> components;
    
    
    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    /**
     * @return the components
     */
    public Set<Component> getComponents() {
        return components;
    }

    /**
     * @param components the components to set
     */
    public void setComponents(Set<Component> components) {
        this.components = components;
    }



}
