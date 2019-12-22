package hello.controllers;

import hello.helpers.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/user/add")
    public String add(@RequestBody String inputJson){
        return userService.userAdd(inputJson);
    }

    @PostMapping("/user/get")
    public String get(@RequestBody String outputJson) {
        return userService.userGet(outputJson);
    }

}
