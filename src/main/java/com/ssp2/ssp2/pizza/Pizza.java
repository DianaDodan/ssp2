package com.ssp2.ssp2.pizza;


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
@Getter
@Setter
@ToString
@Document("pizzas")
public class Pizza {

    @Id
    private String id;
    private String name;
    private List<String> ingredients;
    private List<PizzaSize> sizes;
}
