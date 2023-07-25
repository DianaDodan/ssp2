package com.ssp2.ssp2.pizza;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pizza pizza) {
        pizzaService.create(pizza);
        return ResponseEntity.ok().build();
    }
}
