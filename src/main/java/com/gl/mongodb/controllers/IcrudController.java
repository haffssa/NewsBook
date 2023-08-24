package com.gl.mongodb.controllers;

import com.gl.mongodb.exception.AllAlreadyExisteException;
import com.gl.mongodb.exception.AllDoesntExisteException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IcrudController <T,D,S>{
    ResponseEntity<S> create(T body) throws AllAlreadyExisteException;

    ResponseEntity<S> update(T body, D id) throws AllDoesntExisteException, AllAlreadyExisteException;

    ResponseEntity<S> delete(D id) throws AllDoesntExisteException;

    ResponseEntity<S> find(D id) throws AllDoesntExisteException;

    ResponseEntity<List<S>> fetchAll();
}
