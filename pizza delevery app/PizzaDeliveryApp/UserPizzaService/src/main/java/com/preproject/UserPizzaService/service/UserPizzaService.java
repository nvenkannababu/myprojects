package com.preproject.UserPizzaService.service;

import com.preproject.UserPizzaService.domain.Order;
import com.preproject.UserPizzaService.domain.Pizza;
import com.preproject.UserPizzaService.domain.User;
import com.preproject.UserPizzaService.exception.PizzaAlreadyExistException;
import com.preproject.UserPizzaService.exception.PizzaNotFoundException;
import com.preproject.UserPizzaService.exception.UserAlreadyExistsException;
import com.preproject.UserPizzaService.exception.UserNotFoundException;
import com.preproject.UserPizzaService.proxy.UserProxy;
import com.preproject.UserPizzaService.repository.UserPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserPizzaService implements IUserPizzaService{

    private UserPizzaRepository userPizzaRepository;

    @Autowired
    public UserPizzaService(UserPizzaRepository userPizzaRepository) {
        this.userPizzaRepository = userPizzaRepository;
    }

    @Autowired
    private UserProxy userProxy;
    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if(userPizzaRepository.findById(user.getUserName()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        User user1 = userPizzaRepository.save(user);
        if (!(user1.getUserName().isEmpty())) {
            ResponseEntity responseEntity = userProxy.saveUser(user1);
            System.out.println(responseEntity.getBody());
        }
        return user1;
    }

    @Override
    public User saveItemToCart(Pizza pizza, String userName) throws UserNotFoundException, PizzaAlreadyExistException {
        if(userPizzaRepository.findById(userName).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = userPizzaRepository.findById(userName).get();
        if(user.getCartList() == null)
        {
            user.setCartList(Arrays.asList(pizza));
        }
        else {
            List<Pizza> pizzas = user.getCartList();

            if (pizzas.stream().anyMatch(item -> item.getPizzaId()==pizza.getPizzaId())){
                throw new PizzaAlreadyExistException();
            }

            pizzas.add(pizza);
            user.setCartList(pizzas);
        }
        return userPizzaRepository.save(user);
    }

    @Override
    public List<Pizza> getCartItems(String userName) throws UserNotFoundException {
        if(userPizzaRepository.findById(userName).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return userPizzaRepository.findById(userName).get().getCartList();
    }

    @Override
    public User deleteCartItem(String userName, Pizza pizza, int pizzaId) throws UserNotFoundException, PizzaNotFoundException {
        return null;
    }


    @Override
    public User saveOrder(Order order, String userName) throws UserNotFoundException {
        if(userPizzaRepository.findById(userName).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = userPizzaRepository.findById(userName).get();
        if(user.getOrderList() == null)
        {
            user.setOrderList(Arrays.asList(order));
        }
        else {
            List<Order> orders = user.getOrderList();
            orders.add(order);
            user.setOrderList(orders);
        }
        return userPizzaRepository.save(user);
    }

    @Override
    public List<Order> getAllOrders(String userName) throws UserNotFoundException {
        if(userPizzaRepository.findById(userName).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return userPizzaRepository.findById(userName).get().getOrderList();
    }
}
