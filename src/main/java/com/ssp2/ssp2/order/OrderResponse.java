package com.ssp2.ssp2.order;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderResponse {
    private final List<Order> orders;
    private final double priceSum;
}
