package com.gl.mongodb.exception.handler;

import com.gl.mongodb.exception.AllAlreadyExisteException;
import com.gl.mongodb.exception.AllDoesntExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class NewsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AllDoesntExisteException.class)
    ProblemDetail handleNewsDoesntExisteException(AllDoesntExisteException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("News Not Found");
        return problemDetail;
    }
    @ExceptionHandler(AllAlreadyExisteException.class)
    ProblemDetail handleNewsAlreadyExisteException(AllAlreadyExisteException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
        problemDetail.setTitle("News already Excite ");
        return problemDetail;
    }
}
