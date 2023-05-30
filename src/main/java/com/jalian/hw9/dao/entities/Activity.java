package com.jalian.hw9.dao.entities;
import javafx.beans.DefaultProperty;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "activity")
@DynamicInsert
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
/*
    @JoinColumn(name = "userId")
    //@ForeignKey(foreignKeyDefinition = User.class)
    //@Column(nullable = false)
    targetEntity = User.class
        //@ManyToOne(targetEntity = ActivityState.class)
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)//right way
    private User user;

    /*@JoinColumn("userId")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }*/

    @Column(columnDefinition = "ENUM('open', 'copleted', 'inProgress')", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityState activityState;
    //@ColumnDefault("(CURRENT_DATE)")


    @Column(name = "createDate", columnDefinition = "Date default (CURRENT_DATE)", insertable = true)
    private Date createDate;
    public Activity(String name, ActivityState activityState) {
        this.name = name;
        this.activityState = activityState;
    }
    public Activity() {
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ActivityState getActivityState() {
        return activityState;
    }
    public void setActivityState(ActivityState activityState) {
        this.activityState = activityState;
    }
    @Override
    public String toString() {
        return "id: " + id + ", user username: " + user.getUsername()  + ", name: " + name + ", state: " + activityState.name() + ", create date: " + createDate.toString() + "\n";
    }
}
