package com.preproject.UserPizzaService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Pizza not found")
public class PizzaNotFoundException extends Exception{
}
