package com.preproject.UserPizzaService.service;


import com.preproject.UserPizzaService.domain.Pizza;
import com.preproject.UserPizzaService.exception.PizzaAlreadyExistException;
import com.preproject.UserPizzaService.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService implements IPizzaService{

    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    @Override
    public Pizza savePizza(Pizza pizza) throws PizzaAlreadyExistException {
        if(pizzaRepository.findById(pizza.getPizzaId()).isPresent())
        {
            throw new PizzaAlreadyExistException();
        }
        return pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }
}
