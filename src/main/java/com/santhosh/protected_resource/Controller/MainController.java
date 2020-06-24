package com.santhosh.protected_resource.Controller;

import com.santhosh.protected_resource.ProtectedResourceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(ProtectedResourceApplication.class);


    @GetMapping("/get")
    public String send(){
        log.info("Get request");
        return " You have the write access to this resource";
    }

}
