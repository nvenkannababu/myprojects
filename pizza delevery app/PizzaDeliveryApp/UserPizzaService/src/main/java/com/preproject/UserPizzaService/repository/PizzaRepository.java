package com.preproject.UserPizzaService.repository;


import com.preproject.UserPizzaService.domain.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends MongoRepository<Pizza,Integer> {
}
