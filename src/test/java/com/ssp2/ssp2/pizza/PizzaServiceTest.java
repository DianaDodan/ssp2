package com.ssp2.ssp2.pizza;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.ssp2.ssp2.exception.FailedToSavePizzaException;
import com.ssp2.ssp2.exception.InvalidPizzaException;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PizzaServiceTest {

    @Mock
    private PizzaRepo pizzaRepo;
    @InjectMocks
    private PizzaService onTest;

    @Test
    public void create_whenValidPizza_thenCreatePizza() {
        //given
        Pizza pizza = givenPizza();

        //when
        when(pizzaRepo.save(pizza)).thenReturn(pizza);

        //then
        onTest.create(pizza);
    }

    @Test
    public void create_whenFailsToSave_thenThrowException() {
        //given
        Pizza pizza = givenPizza();

        //when
        when(pizzaRepo.save(pizza)).thenThrow(IllegalArgumentException.class);

        //then
        assertThrows(FailedToSavePizzaException.class,() -> onTest.create(pizza));
    }

    @Test
    public void create_whenPizzaIsNull_thenThrowException() {
        //given
        Pizza pizza = null;

        //then
        assertThrows(InvalidPizzaException.class,() -> onTest.create(pizza));
    }

    @Test
    public void create_whenPizzaNameIsNull_thenThrowException() {
        //given
        Pizza pizza = new Pizza("id", null, Collections.emptyList(), Collections.emptyList());

        //then
        assertThrows(InvalidPizzaException.class,() -> onTest.create(pizza));
    }

    @Test
    public void create_whenPizzaIngredientsAreNull_thenThrowException() {
        //given
        Pizza pizza = new Pizza("id", "pizza", null, Collections.emptyList());

        //then
        assertThrows(InvalidPizzaException.class,() -> onTest.create(pizza));
    }

    @Test
    public void create_whenPizzaSizesAreNull_thenThrowException() {
        //given
        Pizza pizza = new Pizza("id", "pizza", Collections.emptyList(), null);

        //then
        assertThrows(InvalidPizzaException.class,() -> onTest.create(pizza));
    }


    private Pizza givenPizza() {
        return new Pizza("test", "pizza", Collections.emptyList(), Collections.emptyList());
    }
}
