package com.jalian.hw9.dao.entities;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
@Entity
@Table(name = "ourUser")
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    //@JoinColumn(name = "userId")     cascade = CascadeType.ALL, orphanRemoval = true
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Activity> activities;
    @Column(name = "fullName")
    private String fullName;
    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Activity> getActivities() {
        return activities;
    }
    public void setActivities(LinkedList<Activity> activities) {
        this.activities = activities;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", activities=" + activities +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}