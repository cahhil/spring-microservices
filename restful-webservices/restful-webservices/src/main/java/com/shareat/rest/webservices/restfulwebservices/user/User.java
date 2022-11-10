package com.shareat.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="user_table")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Legal Name has to be at least 2 characters long")
    //@JsonProperty("name")
    private String legal_name;

    @Size(min=2, message = "Legal Name has to be at least 2 characters long")
    private String user_name;

    @Past(message = "Birth date should be in the past")
    private LocalDate birthDate;
    //TODO: change to geolocalization
    private String location;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User() {
    }

    public User(Integer id, String legal_name, String user_name,
                LocalDate birthDate, String location) {
        this.id = id;
        this.legal_name = legal_name;
        this.user_name = user_name;
        this.birthDate = birthDate;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLegal_name() {
        return legal_name;
    }

    public void setLegal_name(String legal_name) {
        this.legal_name = legal_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getLocation() {
        return location;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
