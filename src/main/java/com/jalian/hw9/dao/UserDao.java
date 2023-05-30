package com.jalian.hw9.dao;
import com.jalian.hw9.dao.entities.User;
import java.util.List;
public interface UserDao extends Dao<User, String> {
    public List getActivities(String username);
}
