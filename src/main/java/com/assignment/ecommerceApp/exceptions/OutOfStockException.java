package com.assignment.ecommerceApp.exceptions;

public class OutOfStockException extends Exception {
    public OutOfStockException() {
        super();
    }

    public OutOfStockException(String message) {
        super(message);
    }
}
