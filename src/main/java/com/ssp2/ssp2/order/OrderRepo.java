package com.ssp2.ssp2.order;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrderRepo extends MongoRepository<Order, String> {

    @Query("{username: '?0', archived: 'true'}")
    List<Order> getAllOrders(String username);
}
