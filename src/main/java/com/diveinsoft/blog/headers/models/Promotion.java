package com.diveinsoft.blog.headers.models;

import lombok.Builder;
import lombok.Data;

import java.time.*;
import java.util.Date;

@Data
@Builder
public class Promotion {
    private Long id;
    private String type;
    private String title;
    private String fullText;
    private Double discount;
    private String imageUrl;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private String code;

    public static Promotion[] DEMO_PROMOTIONS = new Promotion[] {
            Promotion.builder()
                    .id(500L)
                    .type("INTERNAL")
                    .title("Free shipping on orders over $50")
                    .fullText("Save now by order over $50 worth of stuff and get free shipping via our drone army.")
                    .discount(0.0)
                    .imageUrl("https://pics.diveinsoft.com/images/spring_freeship.png")
                    .startDate(OffsetDateTime.of(LocalDate.of(2024, 4, 10), LocalTime.of(9, 0), ZoneOffset.of("+5")))
                    .endDate(OffsetDateTime.of(LocalDate.of(2024, 5, 1), LocalTime.of(23, 59), ZoneOffset.of("+5")))
                    .code("FREESHIPSPRING24")
                    .build(),
            Promotion.builder()
                    .id(510L)
                    .type("VENDOR")
                    .title("Free wedge with iron set purchase")
                    .fullText("Get a FREE Ping wedge with purchase of any G430 iron set (4-PW)")
                    .discount(0.0)
                    .imageUrl("https://pics.diveinsoft.com/images/spring_freeship.png")
                    .startDate(OffsetDateTime.of(LocalDate.of(2024, 4, 10), LocalTime.of(9, 0), ZoneOffset.of("+5")))
                    .endDate(OffsetDateTime.of(LocalDate.of(2024, 5, 1), LocalTime.of(23, 59), ZoneOffset.of("+5")))
                    .code("PINGPROMO1Q24")
                    .build()

    };
}
