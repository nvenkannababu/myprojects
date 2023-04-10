package com.preproject.UserPizzaService.service;

import com.preproject.UserPizzaService.domain.Order;
import com.preproject.UserPizzaService.domain.Pizza;
import com.preproject.UserPizzaService.domain.User;
import com.preproject.UserPizzaService.exception.PizzaAlreadyExistException;
import com.preproject.UserPizzaService.exception.PizzaNotFoundException;
import com.preproject.UserPizzaService.exception.UserAlreadyExistsException;
import com.preproject.UserPizzaService.exception.UserNotFoundException;

import java.util.List;

public interface IUserPizzaService {
    User registerUser(User user) throws UserAlreadyExistsException;
    User saveItemToCart(Pizza pizza, String userName) throws UserNotFoundException, PizzaAlreadyExistException;

    List<Pizza> getCartItems(String userName) throws UserNotFoundException;
    User deleteCartItem(String userName,Pizza pizza,int pizzaId) throws UserNotFoundException, PizzaNotFoundException;


    User saveOrder(Order order,String userName) throws UserNotFoundException;
    List<Order> getAllOrders(String userName) throws UserNotFoundException;
}
