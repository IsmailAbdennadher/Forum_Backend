package com.aymax.forum.controller;

import com.aymax.forum.entity.User;
import com.aymax.forum.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService service ;

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Long id){
        return service.getUserById(id);
    }
}
