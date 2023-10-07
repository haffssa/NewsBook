package com.gl.mongodb.controllers.Impl;

import com.gl.mongodb.controllers.UserController;
import com.gl.mongodb.dto.UserDto;
import com.gl.mongodb.exception.AllAlreadyExisteException;
import com.gl.mongodb.exception.AllDoesntExisteException;
import com.gl.mongodb.model.User;
import com.gl.mongodb.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping
    @Override
    public ResponseEntity<User> create(@RequestBody UserDto body) throws AllAlreadyExisteException {
        log.info("UserController::create request body {}", body);
        User myUser = modelMapper.map (body,User.class);
        return new ResponseEntity<>(userService.create (myUser), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    @Override
    public ResponseEntity<User> update(@RequestBody  UserDto body,@PathVariable String id) throws AllDoesntExisteException, AllAlreadyExisteException {
        log.info("UserController::update request body {"+body+"} and path variable "+id);
        User myUser = modelMapper.map (body,User.class);
        return new ResponseEntity<>(userService.update (myUser,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<User> delete(@PathVariable  String id) throws AllDoesntExisteException {
        log.info("UserController::delete   path variable "+id);
        userService.delete (id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping ("/{id}")
    @Override
    public ResponseEntity<User> find(@PathVariable String id) throws AllDoesntExisteException {
        log.info("UserController::find   path variable "+id);
        return new ResponseEntity<>(userService.find (id), HttpStatus.OK);
    }
    @GetMapping
    @Override
    public ResponseEntity<List<User>> fetchAll() {
        log.info("UserController::fetchAll ");
        return new ResponseEntity<>(userService.fetchAll (), HttpStatus.OK);
    }
}
