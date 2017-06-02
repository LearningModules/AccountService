package com.poc.accountservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by z001nlh on 5/14/17.
 */
//@Entity
//@Table(name = "T_CONTACTS")
public class Contact implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Integer id;

    @Column(name = "firstname", length = 255, nullable = false)
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
