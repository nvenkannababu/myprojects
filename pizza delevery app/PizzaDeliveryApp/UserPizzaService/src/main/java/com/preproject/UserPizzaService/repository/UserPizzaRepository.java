package com.preproject.UserPizzaService.repository;

import com.preproject.UserPizzaService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPizzaRepository extends MongoRepository<User,String> {
}
