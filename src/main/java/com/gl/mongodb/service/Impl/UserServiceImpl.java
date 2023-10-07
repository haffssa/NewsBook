package com.gl.mongodb.service.Impl;

import com.gl.mongodb.exception.AllAlreadyExisteException;
import com.gl.mongodb.exception.AllDoesntExisteException;
import com.gl.mongodb.model.User;
import com.gl.mongodb.repositoriy.UserRepository;
import com.gl.mongodb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public User create(User body) throws AllAlreadyExisteException {
        if(userRepository.existsByAccountName (body.getAccountName ()))
            throw new AllAlreadyExisteException("User with AccountName already excite  ");
        return userRepository.save (body);
    }

    @Override
    public User update(User body, String id) throws AllAlreadyExisteException, AllDoesntExisteException {
        if(userRepository.existsByAccountName (body.getAccountName ()))
            throw new AllAlreadyExisteException("User with AccountName already excite ");
        User old = this.find (id);
        old.setId (id);
        return userRepository.save (old);


    }

    @Override
    public void delete(String id) throws AllDoesntExisteException {
        User todelete = this.find (id);
        userRepository.delete (todelete);
    }

    @Override
    public User find(String id) throws AllDoesntExisteException {
        return userRepository.findById (id).orElseThrow (() ->new AllDoesntExisteException("User doesn't excite "));
    }

    @Override
    public List<User> fetchAll() {
        return userRepository.findAll ();
    }

}
