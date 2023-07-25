package com.ssp2.ssp2.order;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.ssp2.ssp2.exception.FailedToRetrieveOrdersException;
import com.ssp2.ssp2.exception.UsernameNotFoundException;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepo orderRepo;
    @InjectMocks
    private OrderService onTest;

    @Test
    public void getAll_whenValidUsername_thenReturnOrderHistory() {
        //given
        String username = "username";

        //when
        when(orderRepo.getAllOrders(username)).thenReturn(Collections.emptyList());

        //then
        assertNotNull(onTest.getAll(username));
    }

    @Test
    public void getAll_whenUsernameNotFound_thenThrowException() {
        //given
        String username = "username";

        //when
        when(orderRepo.getAllOrders(username)).thenThrow(IllegalArgumentException.class);

        //then
        assertThrows(UsernameNotFoundException.class, () -> onTest.getAll(username));
    }

    @Test
    public void getAll_whenGenericException_thenThrowException() {
        //given
        String username = "username";

        //when
        when(orderRepo.getAllOrders(username)).thenThrow(RuntimeException.class);

        //then
        assertThrows(FailedToRetrieveOrdersException.class, () -> onTest.getAll(username));
    }
}
