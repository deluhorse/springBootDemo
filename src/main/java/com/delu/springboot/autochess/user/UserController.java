package com.delu.springboot.autochess.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by delu on 2019-03-19.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping("/query")
//    public User testQuery() {
//        return userService.selectUserByName("Daisy");
//    }
}
