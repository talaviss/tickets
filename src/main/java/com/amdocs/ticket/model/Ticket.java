package com.amdocs.ticket.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by user on 14/08/2017.
 */
//@Entity
@Document(collection = "TICKETS")
public class Ticket {

    @Id
    private String id;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    @Override
    public String toString() {
        return String.format(
                "Ticket[id=%s, title='%s', description='%s']",
                id, title, description);
    }

}



