package com.diveinsoft.blog.headers.order;

import com.diveinsoft.blog.headers.models.Order;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    /**
     * Emits a "nocache" cache control header.  Fake order numbers are 1000, 1001 and 1002.
     * @param customerId
     * @return
     */
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable Long customerId) {
        List<Order> foundOrders = Arrays.stream(Order.DEMO_ORDERS)
                .filter(order -> order.getCustomerId().equals(customerId))
                .toList();
        return ResponseEntity.ok()
                .cacheControl(CacheControl.noCache())
                .body(foundOrders);
    }
}
