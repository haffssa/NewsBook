package com.gl.mongodb.service;

import com.gl.mongodb.exception.AllAlreadyExisteException;
import com.gl.mongodb.exception.AllDoesntExisteException;

import java.util.List;

public interface IcrudService<T> {
    T create(T body) throws AllAlreadyExisteException;

    T update(T body, String id) throws AllAlreadyExisteException, AllDoesntExisteException;

    void delete(String id) throws AllDoesntExisteException;

    T find(String id) throws AllDoesntExisteException, AllDoesntExisteException;

    List<T> fetchAll();
}
