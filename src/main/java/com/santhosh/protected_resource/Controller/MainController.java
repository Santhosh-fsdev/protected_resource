package com.santhosh.protected_resource.Controller;

import com.santhosh.protected_resource.Model.Inventory;
import com.santhosh.protected_resource.Model.Order;
import com.santhosh.protected_resource.ProtectedResourceApplication;
import com.santhosh.protected_resource.Repository.OrderRepository;
import com.santhosh.protected_resource.Repository.ProductsRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(ProtectedResourceApplication.class);

    @Autowired
    private ProductsRespository productsRespository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/check")
    public String check() {
        return "you have the authority";
    }

    @GetMapping("/get")
    public String send() {
        log.info("Get request");
        return " You have the write access to this resource";
    }

    @GetMapping("/listall")
    public List<Inventory> listall() {
        log.info("Querying all details from database");
        return productsRespository.findAll();
    }

    @PostMapping("/insert")
    public String insert(@RequestBody Inventory inventory) {
        productsRespository.save(inventory);

        log.info("Data Saved");
        return "Product named" +" " + inventory.getName() + " "+ " Added Successfully";
    }

    @PostMapping("/order")
    public String insert(@RequestBody Order order) {
        orderRepository.save(order);

        log.info("Data Saved");
        return "Order named" + " "+  order.getName() + " "+ "Placed Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String id) {
        productsRespository.deleteById(id);
        return "Product with ID" + " "+ id + " "+" Deleted Successfully";
    }


}
