package com.santhosh.protected_resource.Repository;

import com.santhosh.protected_resource.Model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRespository extends MongoRepository<Inventory,String> {

}
