package com.gl.mongodb.controllers;

import com.gl.mongodb.exception.NewsAlreadyExisteException;
import com.gl.mongodb.exception.NewsDoesntExisteException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IcrudController <T,D,S>{
    ResponseEntity<S> create(T body) throws NewsAlreadyExisteException;

    ResponseEntity<S> update(T body, D id) throws NewsDoesntExisteException, NewsAlreadyExisteException;

    ResponseEntity<S> delete(D id) throws NewsDoesntExisteException;

    ResponseEntity<S> find(D id) throws NewsDoesntExisteException;

    ResponseEntity<List<S>> fetchAll();
}
