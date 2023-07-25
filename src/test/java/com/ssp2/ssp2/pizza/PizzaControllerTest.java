package com.ssp2.ssp2.pizza;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class PizzaControllerTest {

    @Mock
    private PizzaService pizzaService;
    @InjectMocks
    private PizzaController onTest;

    @Test
    public void create_whenPizzaIsValid_thenReturnOkResponse() {
        //given
        Pizza pizza = new Pizza("test", "pizza", Collections.emptyList(), Collections.emptyList());

        //then
        assertEquals(HttpStatus.OK, onTest.create(pizza).getStatusCode());
    }
}