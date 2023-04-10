package com.bej.userauthenticationservice.service;


import com.bej.userauthenticationservice.domain.User;
import com.bej.userauthenticationservice.exception.UserAlreadyExistsException;
import com.bej.userauthenticationservice.repository.UserRepository;
import com.bej.userauthenticationservice.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getUserName()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) throws InvalidCredentialsException {
        User loggedInUser = userRepository.findByUserNameAndPassword(userName,password);
        System.out.println(loggedInUser);
        if(loggedInUser == null)
        {
            throw new InvalidCredentialsException();
        }

        return loggedInUser;
    }
}
