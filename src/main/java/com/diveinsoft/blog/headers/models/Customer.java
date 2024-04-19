package com.diveinsoft.blog.headers.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;

    public static Customer[] DEMO_CUSTOMERS = new Customer[]{
            Customer.builder().id(532L)
                    .name("Vinny Testaverde")
                    .email("vtesta@heisman.org")
                    .phone("8139733676")
                    .address("25 Davis Islands Dr")
                    .city("Tampa")
                    .state("FL")
                    .zip("32819")
                    .country("US")
                    .build(),
            Customer.builder().id(994L)
                    .name("Tom Brady")
                    .email("tbrady@tbrady.com")
                    .phone("911")
                    .address("200 N Dale Mabry Hwy")
                    .city("Tampa")
                    .state("FL")
                    .zip("33612")
                    .country("US")
                    .build(),
            Customer.builder().id(606L)
                    .name("Doug Williams")
                    .email("dwillliamsQB@gmail.com")
                    .phone("9016824116")
                    .address("425 N Poplar Ave")
                    .city("Memphis")
                    .state("TN")
                    .zip("38117")
                    .country("US")
                    .build(),
    };
}
