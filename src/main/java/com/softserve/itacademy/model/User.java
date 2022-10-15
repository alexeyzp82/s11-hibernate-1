package com.softserve.itacademy.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.cfg.NotYetImplementedException;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name="users")
public class User  {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    // @ManyToMany(mappedBy = "collaborator_id")
    // TODO: this should be connected to owner_id in todos
    private int id;

    @Column(name="first_name")
    @Pattern(regexp = "[A-Z][a-z]*([-][A-Z][a-z]*)?")
    @Size(min=1,max = 255)
    @NotBlank (message = "Name cannot be empty.")
    private String firstName;

    @Column(name="last_name")
    @Pattern(regexp = "[A-Z][a-z]*([-][A-Z][a-z]*)?")
    @Size(min=1,max = 255)
    @NotBlank (message = "Last name cannot be empty.")
    private String lastName;

    @Column(name="email")
    @NotBlank
    @Email(message = "Email is not valid.")
    private String email;

    @Column(name="password")
    //@NotNull(message = "Password should not be empty.")
    //@NotBlank @Size(min=1,max = 255)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    /**
     * Default public constructor.
     * */
    public User(){

    }

    /**
     * Getters & Setters for fields.
     * */
    public int getId() {
        return id;
    }

    //TODO : Check if we need setter for generated value
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Role getRole() {
      return role;
    }

    public void setRole(Role role) {
       this.role = role;
    }
}
