package com.ssp2.ssp2.pizza;

import com.ssp2.ssp2.exception.FailedToSavePizzaException;
import com.ssp2.ssp2.exception.InvalidPizzaException;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PizzaService {

    private final PizzaRepo pizzaRepo;

    public void create(Pizza pizza) {
        validate(pizza);

        try {
            pizzaRepo.save(pizza);
        } catch (IllegalArgumentException e) {
            throw new FailedToSavePizzaException(pizza);
        }
    }

    private void validate(Pizza pizza) {
        if (Objects.isNull(pizza)) {
            throw new InvalidPizzaException(pizza);
        }

        if (Stream.of(pizza.getName(), pizza.getIngredients(), pizza.getSizes()).anyMatch(Objects::isNull)) {
            throw new InvalidPizzaException(pizza);
        }
    }
}
