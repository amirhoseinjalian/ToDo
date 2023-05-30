package com.jalian.hw9.dao;
import java.util.List;
public interface Dao<Value, Key> extends Closable {
    public Value add(Value value);
    public Value getById(Key key);
    public List<Value> getAll();
    public boolean update(Value value);
}