package com.jalian.hw9.dao;
import com.jalian.hw9.dao.entities.Activity;
import com.jalian.hw9.dao.entities.User;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
public class UserDaoImpl extends DaoImpl<User, String> implements UserDao {
    public UserDaoImpl() {
        super();
        aClass = User.class;
    }
    public List getActivities(String username) {
        List activities = new LinkedList<Activity>();
        Query query = entityManager.createNativeQuery("select * from Activity where userId = ?1", Activity.class);
        query.setParameter(1, username);
        activities = query.getResultList();
        return activities;
        //select a from Activity a where a.user.username = ?1   correct jpql
    }
}
