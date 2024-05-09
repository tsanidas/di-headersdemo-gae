package com.diveinsoft.blog.headers.product;

import java.util.HashMap;
import java.util.Optional;

/**
 * A very fake cache manager
 */
public class ProductCache {
    private final HashMap<Long, String> servedProducts = new HashMap<>();

    public Optional<String> getHashForId(Long productId) {
        String nullableValue = servedProducts.get(productId);
        if (nullableValue != null) {
            return Optional.of(nullableValue);
        } else {
            return Optional.empty();
        }
    }

    public void putHashForId(Long productId, String hash) {
        servedProducts.put(productId, hash);
    }
}
