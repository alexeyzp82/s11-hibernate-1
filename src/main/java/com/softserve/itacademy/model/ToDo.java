package com.softserve.itacademy.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "created_at")
    @CreationTimestamp
    @NotNull
    private LocalDateTime createdAt;

    @NotBlank
    @Size(max = 255)
    private String title;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToMany
    @JoinTable(
        name = "todo_collaborator",
        joinColumns = @JoinColumn(name = "todo_id"),
        inverseJoinColumns = @JoinColumn(name = "collaborator_id")
    )
    private List<User> collaborators;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
