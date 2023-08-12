package com.gl.mongodb.service;

import java.util.List;

public interface CrudService <T,D>{
    T create(D body);
    T update(D body);
    void delete(D body);
    List<T> findAll();
    T findOne(long id);
}
