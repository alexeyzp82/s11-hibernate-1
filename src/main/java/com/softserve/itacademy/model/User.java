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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    @Pattern(regexp = "[A-Z][a-z]*([-][A-Z][a-z]*)?")
    @Size(min=1,max = 255)
    private String firstName;

    @Column(name="last_name")
    @Pattern(regexp = "[A-Z][a-z]*([-][A-Z][a-z]*)?")
    @Size(min=1,max = 255)
    private String lastName;

    @Column(name="email",unique = true)
    @NotBlank
    @Email(message = "Email is not valid.")
    private String email;

    @Column(name="password",nullable = false)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password should contains at least one uppercase letter, one lowercase letter,one special" +
                    "character,at least one digit,minimum eight in length")
    private String password;

    @ManyToOne(optional = false)//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;


    @ManyToMany (mappedBy = "collaborators")
    private List<ToDo> toDos;

    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    private List<ToDo> ownToDos;

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

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public List<ToDo> getOwnToDos() {
        return ownToDos;
    }

    public void setOwnToDos(List<ToDo> ownToDos) {
        this.ownToDos = ownToDos;
    }

}
