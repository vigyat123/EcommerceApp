package com.assignment.ecommerceApp.controllers;

import com.assignment.ecommerceApp.dto.Status;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
public class UserRestController {
    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public Status validateLogin() {
        return new Status("User successfully authenticated");
    }

    /*@RequestMapping(
            value = "/createUser",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> createUser(@RequestBody @Valid final Inventory inventory){
        inventoryService.addItem(inventory);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }*/

}
