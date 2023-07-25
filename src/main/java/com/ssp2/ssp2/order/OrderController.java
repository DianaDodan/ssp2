package com.ssp2.ssp2.order;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/history")
    public ResponseEntity<OrderResponse> getAll(@RequestParam String username) {
        List<Order> orders = orderService.getAll(username);
        return ResponseEntity.ok(new OrderResponse(orders, orders.stream().mapToDouble(Order::getTotalPrice).sum()));
    }
}
