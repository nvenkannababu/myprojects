package com.preproject.UserPizzaService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND,reason = "already exist")
public class PizzaAlreadyExistException extends Exception{
}
