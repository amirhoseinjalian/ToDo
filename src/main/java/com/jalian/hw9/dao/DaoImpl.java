package com.jalian.hw9.dao;
import com.jalian.hw9.projectUtil.ProjectUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
public abstract class DaoImpl <Value, Key> implements Dao<Value, Key> {
    protected Class<Value> aClass;
    protected EntityManager entityManager = ProjectUtil.getEntityManager();
    public DaoImpl() {
    }
    public Value add(Value value) {
        entityManager.getTransaction().begin();
        entityManager.persist(value);
        entityManager.getTransaction().commit();
        return value;
    }
    public Value getById(Key key) {
        return entityManager.find(aClass, key);
    }
    public List<Value> getAll() {
        Query query = entityManager.createQuery("select a from " + aClass.getSimpleName() + " a", aClass);
        //query.setParameter(1, aClass.getSimpleName());
        List<Value> values;
        entityManager.getTransaction().begin();
        values = query.getResultList();
        entityManager.getTransaction().commit();
        return values;
    }
    public boolean update(Value value) {
        entityManager.getTransaction().begin();
        entityManager.merge(value);
        entityManager.getTransaction().commit();
        return true;
    }
    public void close() {
        entityManager.close();
        ProjectUtil.shutdown();
    }
}