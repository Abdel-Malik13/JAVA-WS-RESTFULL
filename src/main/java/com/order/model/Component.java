/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.model;

/**
 *
 * @author Numalama
 */
public class Component {
     private Long id;
    
    //private ComponentStatus status;
    
    private String name;
    
    private Long qty;
    
    private Order order;

    
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
     * @return the qte
     */
    public Long getQty() {
        return qty;
    }

    /**
     * @param qte the qte to set
     */
    public void setQty(Long qty) {
        this.qty = qty;
    }

        
    /**
     * @return the status

    public ComponentStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set

    public void setStatus(ComponentStatus status) {
        this.status = status;
    }
    * */

}
