package com.preproject.UserPizzaService.service;



import com.preproject.UserPizzaService.domain.Pizza;
import com.preproject.UserPizzaService.exception.PizzaAlreadyExistException;

import java.util.List;

public interface IPizzaService {
    Pizza savePizza(Pizza pizza) throws PizzaAlreadyExistException;
    List<Pizza> getAllPizza();
}
