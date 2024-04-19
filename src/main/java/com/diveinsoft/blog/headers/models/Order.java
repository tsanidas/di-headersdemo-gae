package com.diveinsoft.blog.headers.models;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class Order {
    @NonNull private Long id;
    @NonNull private Long customerId;
    @NonNull private Date dateOrdered;
    @NonNull private String status;
    @NonNull private Double totalPrice;
    @NonNull private Double totalAmount;
    @NonNull private Double totalTax;
    @NonNull private Double totalDiscount;
    @NonNull private Double taxRate;

    public static Order[] DEMO_ORDERS = new Order[] {
            new Order(1000L, 532L, new Date(), "SHIPPED", 200.26, 224.21, 23.95, 0.0, 7.75),
            new Order(1001L, 994L, new Date(), "ORDERED", 526.15, 550.00, 23.15, 0.0, 5.75),
            new Order(1002L, 606L, new Date(), "COMPLETED", 51.14, 55.18, 4.04, 0.0, 6.25)
    };
}
