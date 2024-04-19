package com.diveinsoft.blog.headers.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class Product {
    @NonNull private Long id;
    @NonNull private String brand;
    @NonNull private String description;
    @NonNull private String imageUrl;
    @NonNull private Double price;
    @NonNull private Double weight;
    @NonNull private String category;
    @NonNull private Double rating;

    public static Product[] DEMO_PRODUCTS = new Product[]{
            new Product(1L, "Ping", "G430 Irons",
              "https://cdne-prod-media-ping.azureedge.net/mediastorage/mediastorage/ping-eu/medialibrary/clubs/irons/g430/g430_iron_cavity_708x708.jpg",
              899.99, 35.0, "IRONS", 4.8),
            new Product(2L, "Titleist", "ProV1 Golf Balls",
                    "https://acushnet.scene7.com/is/image/titleist/2023-Pro-V1-Yellow-PDP-Reel-Tile?wid=800&fmt=png-alpha",
                    55.0, 2.0, "BALLS", 4.9),
            new Product(3L, "Kirkland Signature", "Leather Golf Glove 4-pack - Left Handed",
                    "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026540&itemId=100737685-847&recipeName=680",
                    29.99, 0.5, "GLOVES", 4.7)
    };
}
