package com.ssp2.ssp2.exception;

import com.ssp2.ssp2.pizza.Pizza;

public class InvalidPizzaException extends RuntimeException{

    public InvalidPizzaException(Pizza pizza) {
        super(String.format("Invalid pizza: %s", pizza));
    }
}
