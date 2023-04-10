package com.bej.userauthenticationservice.service;


import com.bej.userauthenticationservice.domain.User;
import com.bej.userauthenticationservice.exception.UserAlreadyExistsException;
import com.bej.userauthenticationservice.exception.InvalidCredentialsException;

public interface UserService {

    User saveUser(User user) throws UserAlreadyExistsException;
    User findByUserNameAndPassword(String userName,String password) throws InvalidCredentialsException;



}
