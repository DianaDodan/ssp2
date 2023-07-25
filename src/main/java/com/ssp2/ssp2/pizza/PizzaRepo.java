package com.ssp2.ssp2.pizza;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaRepo extends MongoRepository<Pizza, String> {

}
