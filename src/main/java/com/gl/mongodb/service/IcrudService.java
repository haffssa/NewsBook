package com.gl.mongodb.service;

import com.gl.mongodb.exception.NewsAlreadyExisteException;
import com.gl.mongodb.exception.NewsDoesntExisteException;

import java.util.List;

public interface IcrudService<T> {
    T create(T body) throws NewsAlreadyExisteException;

    T update(T body, Long id) throws NewsAlreadyExisteException, NewsDoesntExisteException;

    void delete(Long id) throws NewsDoesntExisteException;

    T find(Long id) throws NewsDoesntExisteException;

    List<T> fetchAll();
}
