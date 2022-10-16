package com.softserve.itacademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3, max = 200)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    @NotNull(message = "Priority cannot be null")
    private Priority priority;

    @ManyToOne(optional = false)
    @JoinColumn(name = "todo_id", referencedColumnName = "id")
    private ToDo todo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private State state;

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", todo=" + todo +
                ", state=" + state +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public ToDo getTodo() {
        return todo;
    }

    public void setTodo(ToDo todo) {
        this.todo = todo;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}



