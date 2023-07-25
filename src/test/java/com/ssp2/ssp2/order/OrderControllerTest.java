package com.ssp2.ssp2.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    @Mock
    private OrderService orderService;
    @InjectMocks
    private OrderController onTest;

    @Test
    public void getAll_whenValidUsername_thenReturnOkResponse() {
        //given
        String username = "username";

        //when
        when(orderService.getAll(username)).thenReturn(Collections.emptyList());

        //then
        assertEquals(HttpStatus.OK, onTest.getAll(username).getStatusCode());
    }

    @Test
    public void getAll_whenOrdersReturned_thenSumTotalIsCorrect() {
        //given
        String username = "username";
        Order order = new Order(null, null, null, 12.0f, true, null, null, null);
        Order order2 = new Order(null, null, null, 21.0f, true, null, null, null);
        List<Order> orders = List.of(order, order2);

        //when
        when(orderService.getAll(username)).thenReturn(orders);

        //then
        assertEquals(33.0, onTest.getAll(username).getBody().getPriceSum());
    }
}
