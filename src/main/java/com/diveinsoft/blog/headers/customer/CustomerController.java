package com.diveinsoft.blog.headers.customer;

import com.diveinsoft.blog.headers.models.Customer;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    /**
     * Emits a "noStore" cache control header.  Fake customer IDs are 532, 994 or 606.
     * @param customerId
     * @return
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Optional<Customer> foundCustomer = Arrays.stream(Customer.DEMO_CUSTOMERS)
                .filter(Customer -> Customer.getId().equals(customerId)).findFirst();
        return foundCustomer.map(Customer -> ResponseEntity.ok()
                        .cacheControl(CacheControl.noStore())
                        .body(Customer)
                )
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
