package com.jalian.hw9.dao;
import com.jalian.hw9.dao.entities.Activity;
public class ActivityDaoImpl extends DaoImpl<Activity, Integer> implements ActivityDao {
    public ActivityDaoImpl() {
        super();
        aClass = Activity.class;
    }
}
