package com.preproject.UserPizzaService.controller;

import com.preproject.UserPizzaService.domain.Order;
import com.preproject.UserPizzaService.domain.Pizza;
import com.preproject.UserPizzaService.domain.User;
import com.preproject.UserPizzaService.exception.PizzaAlreadyExistException;
import com.preproject.UserPizzaService.exception.PizzaNotFoundException;
import com.preproject.UserPizzaService.exception.UserAlreadyExistsException;
import com.preproject.UserPizzaService.exception.UserNotFoundException;
import com.preproject.UserPizzaService.service.PizzaService;
import com.preproject.UserPizzaService.service.UserPizzaService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v2")
public class PizzaController {

    private UserPizzaService userPizzaService;
    private PizzaService pizzaService;

    @Autowired
    public PizzaController(UserPizzaService userPizzaService, PizzaService pizzaService) {
        this.userPizzaService = userPizzaService;
        this.pizzaService = pizzaService;
    }


    private ResponseEntity<?> responseEntity;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        try {
            responseEntity =  new ResponseEntity<>(userPizzaService.registerUser(user), HttpStatus.CREATED);
        }
        catch(UserAlreadyExistsException e)
        {
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }

    @PostMapping("/user/cart")
    public ResponseEntity<?> saveItemToCart(@RequestBody Pizza pizza, HttpServletRequest request) throws UserNotFoundException, PizzaAlreadyExistException {
        try {
            System.out.println("header" +request.getHeader("Authorization"));
            Claims claims = (Claims) request.getAttribute("claims");
            System.out.println("email from claims :: " + claims.getSubject());
            String email = claims.getSubject();
            System.out.println("email :: "+email);
            responseEntity = new ResponseEntity<>(userPizzaService.saveItemToCart(pizza, email), HttpStatus.CREATED);
        }
        catch (UserNotFoundException e)
        {
            throw new UserNotFoundException();
        } catch (PizzaAlreadyExistException e) {
            throw new PizzaAlreadyExistException();
        }
        return responseEntity;
    }



    @GetMapping("/user/carts")
    public ResponseEntity<?> getAllCartItems(HttpServletRequest request) throws UserNotFoundException {
        try{
            Claims claims = (Claims) request.getAttribute("claims");
            String userName = claims.getSubject();
            responseEntity = new ResponseEntity<>(userPizzaService.getCartItems(userName), HttpStatus.OK);
        }catch(UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }

    @PostMapping("/user/order")
    public ResponseEntity<?> saveOrder(@RequestBody Order order, HttpServletRequest request) throws UserNotFoundException {
        try {
            System.out.println("header" +request.getHeader("Authorization"));
            Claims claims = (Claims) request.getAttribute("claims");
            System.out.println("email from claims :: " + claims.getSubject());
            String email = claims.getSubject();
            System.out.println("email :: "+email);
            responseEntity = new ResponseEntity<>(userPizzaService.saveOrder(order, email), HttpStatus.CREATED);
        }
        catch (UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }


    @GetMapping("/user/orders")
    public ResponseEntity<?> getAllOrders(HttpServletRequest request) throws UserNotFoundException {
        try{
            Claims claims = (Claims) request.getAttribute("claims");
            String email = claims.getSubject();
            responseEntity = new ResponseEntity<>(userPizzaService.getAllOrders(email), HttpStatus.OK);
        }catch(UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }

    @PutMapping("/user/cart/update/{pizzaId}")
    public ResponseEntity<?> updateUserTrackFromList(@RequestBody Pizza pizza, @PathVariable int pizzaId,HttpServletRequest request) throws UserNotFoundException, PizzaNotFoundException {

        Claims claims = (Claims) request.getAttribute("claims");
        String userName = claims.getSubject();
        return responseEntity;
    }

    @PostMapping("/pizza")
    public ResponseEntity<?> registerUser(@RequestBody Pizza pizza) throws PizzaAlreadyExistException {
        try {
            responseEntity =  new ResponseEntity<>(pizzaService.savePizza(pizza), HttpStatus.CREATED);
        }
        catch(PizzaAlreadyExistException e)
        {
            throw new PizzaAlreadyExistException();
        }
        return responseEntity;
    }

    @GetMapping("/pizzas")
    public ResponseEntity<?> getAllPizza() throws Exception {
        try{
            responseEntity = new ResponseEntity<>(pizzaService.getAllPizza(),HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception();
        }
        return responseEntity;
    }
}
