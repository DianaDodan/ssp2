package com.ssp2.ssp2.order;

import com.ssp2.ssp2.pizza.Deal;
import com.ssp2.ssp2.pizza.Pizza;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document("orders")
public class Order {

    @Id
    private String id;
    private String username;
    private String timestamp;
    private double totalPrice;
    private boolean archived;
    private List<OrderedPizza> pizzas;
    private List<Deal> deals;
    private String delivery;
}
