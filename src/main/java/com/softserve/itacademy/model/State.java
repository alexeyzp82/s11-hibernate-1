package com.softserve.itacademy.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="states")
public class State {

    @Id
    
    private int id;

    private String name;

    /**
     * Public constructor
     * */
    public State(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
