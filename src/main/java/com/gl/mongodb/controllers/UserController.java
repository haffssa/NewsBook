package com.gl.mongodb.controllers;

import com.gl.mongodb.dto.UserDto;
import com.gl.mongodb.model.User;

public interface UserController extends IcrudController<UserDto, String, User>{
}
