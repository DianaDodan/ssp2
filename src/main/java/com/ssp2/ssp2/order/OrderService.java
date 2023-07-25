package com.ssp2.ssp2.order;

import com.ssp2.ssp2.exception.FailedToRetrieveOrdersException;
import com.ssp2.ssp2.exception.UsernameNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public List<Order> getAll(String username) {
        try {
            return orderRepo.getAllOrders(username);
        } catch (IllegalArgumentException e) {
            throw new UsernameNotFoundException(username);
        } catch (Exception e) {
            throw new FailedToRetrieveOrdersException();
        }
    }
}
