package com.ssp2.ssp2.exception;

import com.ssp2.ssp2.pizza.Pizza;

public class FailedToSavePizzaException extends RuntimeException{

    public FailedToSavePizzaException(Pizza pizza) {
        super(String.format("Pizza with ID: %s failed to save.", pizza.getId()));
    }
}
