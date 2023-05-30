package com.jalian.hw9.service;
import com.jalian.hw9.dao.*;
import com.jalian.hw9.dao.entities.Activity;
import com.jalian.hw9.dao.entities.User;
import java.util.List;
public class Service {
    private ActivityDao activityDao = new ActivityDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    public User authentication(User user) {
        String password = user.getPassword();
        user = userDao.getById(user.getUsername());
        if(password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
    public String addUser(User user) {
        userDao.add(user);
        return user.getUsername();
    }
    public void close() {
        userDao.close();
        activityDao.close();
    }
    public int addActivity(Activity activity) {
        activityDao.add(activity);
        return activity.getId();
    }
    public Activity getActivity(int id) {
        return activityDao.getById(id);
    }
    public Activity updateActivity(Activity activity) {
        activityDao.update(activity);
        return activity;
    }
    public List<Activity> getAllUserActivities(String username){
        return userDao.getActivities(username);
    }
    public List<Activity> getAllActivities(){
        return activityDao.getAll();
    }
}