package com.santhosh.protected_resource.Repository;

import com.santhosh.protected_resource.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
