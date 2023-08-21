package com.gl.mongodb.exception;

public class NewsDoesntExisteException extends Exception{
    public NewsDoesntExisteException(String message){
        super(message);
    }
}
