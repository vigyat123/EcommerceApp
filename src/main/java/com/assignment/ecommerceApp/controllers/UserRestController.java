package com.assignment.ecommerceApp.controllers;

import com.assignment.ecommerceApp.dto.Status;
import com.assignment.ecommerceApp.dto.User;
import com.assignment.ecommerceApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin()
@RestController
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public Status validateLogin() {
        return new Status("User successfully authenticated");
    }

    @RequestMapping(
            value = "/createUser",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> createUser(@RequestBody @Valid final User user){
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
