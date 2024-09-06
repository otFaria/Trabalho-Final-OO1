package Model.Dao;

import java.util.List;

public interface IDao<T> {

    //POST
    void save(T obj);

    //PUT
    void update(String id, T newObj);

    //DELETE
    void delete(String id);

    //GET
    T find(String id);

    //GET
    List<T> findAll();
    
    void insert(String id);
}