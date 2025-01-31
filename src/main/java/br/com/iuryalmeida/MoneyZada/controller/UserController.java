package br.com.iuryalmeida.MoneyZada.controller;

import br.com.iuryalmeida.MoneyZada.model.User;
import br.com.iuryalmeida.MoneyZada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}