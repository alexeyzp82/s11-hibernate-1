package com.softserve.itacademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 1, max = 20)
    @Pattern(regexp = "([A-Za-z0-9-_]+)")
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
