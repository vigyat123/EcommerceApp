package com.assignment.ecommerceApp.controllers;

import com.assignment.ecommerceApp.dto.Inventory;
import com.assignment.ecommerceApp.dto.InventoryPage;
import com.assignment.ecommerceApp.dto.ItemType;
import com.assignment.ecommerceApp.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(final InventoryService inventoryService) {
        super();
        this.inventoryService = inventoryService;
    }

    @RequestMapping(
            value = "/addItem",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> addItem(@RequestBody @Valid final Inventory inventory){
        inventoryService.addItem(inventory);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/deleteItemOfSeller/{item_name}/{seller}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> deleteItemOfSeller(@PathVariable("item_name") final String itemName,
                                            @PathVariable("seller") final String seller) throws Exception {
        inventoryService.deleteItemOfSeller(itemName, seller);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/getAllItems",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody
    InventoryPage getAllItems(@RequestParam(value = "pageIndex") final Integer pageIndex,
                              @RequestParam(value = "size") final Integer size){

        return inventoryService.getAllItems(pageIndex, size);
    }

    /*@RequestMapping(
            value = "/getAllItemsByItemType/{item_type}",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody
    InventoryPage getAllItemsByItemType(@RequestParam(value = "pageIndex") final Integer pageIndex,
                              @RequestParam(value = "size") final Integer size,
                              @PathVariable("item_type") final String itemType){

        return inventoryService.getAllItemsByItemType(pageIndex, size, itemType);
    }*/
}
