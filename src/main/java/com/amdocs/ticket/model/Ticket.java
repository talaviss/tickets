package com.amdocs.ticket.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Created by user on 14/08/2017.
 */
@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String title;
    private boolean active;

    public Ticket() {
        super();
    }

    public Ticket(String description, String title, boolean active) {
        super();
        this.description = description;
        this.title = title;
        this.active = active;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }



}



