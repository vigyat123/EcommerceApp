package com.assignment.ecommerceApp.controllers;

import com.assignment.ecommerceApp.dto.Order;
import com.assignment.ecommerceApp.dto.OrdersPage;
import com.assignment.ecommerceApp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrdersController {
    private final OrderService orderService;

    @Autowired
    public OrdersController(final OrderService orderService) {
        super();
        this.orderService = orderService;
    }
    @RequestMapping(
            value = "/addToCart",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> addToCart(@RequestBody @Valid final Order order) throws Exception {
        orderService.createOrder(order);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/getAllOrders",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody
    OrdersPage getAllOrders(@RequestParam(value = "pageIndex") final Integer pageIndex,
                            @RequestParam(value = "size") final Integer size){

        return orderService.getAllOrders(pageIndex, size);
    }

    @RequestMapping(
            value = "/placeOrder/{order_id}",
            method = RequestMethod.PUT,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> placeOrder(@PathVariable("order_id") final Long orderId) throws Exception {
        orderService.changeOrderStatus(orderId, true);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/cancelOrder/{order_id}",
            method = RequestMethod.PUT,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> cancelOrder(@PathVariable("order_id") final Long orderId) throws Exception {
        orderService.changeOrderStatus(orderId, false);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
