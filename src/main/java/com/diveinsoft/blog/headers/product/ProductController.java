package com.diveinsoft.blog.headers.product;

import com.diveinsoft.blog.headers.models.Product;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final Logger LOG = Logger.getLogger(ProductController.class.getName());
    private final ProductCache productCache = new ProductCache();

    /**
     * Emits a "max-age=60" cache control header.  Fake product IDS are 1,2 or 3
     * @param productId
     * @return
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Optional<Product> foundProduct = Arrays.stream(Product.DEMO_PRODUCTS)
                .filter(product -> product.getId().equals(productId)).findFirst();
        return foundProduct.map(product -> ResponseEntity.ok()
                        .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                        .body(product)
                )
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Emits an "etag=" cache control header.  Fake product IDS are 1,2 or 3
     * @param productId
     * @return
     */
    @GetMapping("/v2/{productId}")
    public ResponseEntity<Product> getProductByIdWithCache(
            @PathVariable Long productId,
            @RequestHeader(value = "If-None-Match", required = false) String inHash
    ) {
        // Check the If-None-Match header's value to see if it is in the cache and matches
        if (inHash != null) {
            // RFC says ETag includes double quotes.  Strip these out for easier handling
            inHash = inHash.replaceAll("\"", "");
            Optional<String> existingHash = productCache.getHashForId(productId);
            if (existingHash.isPresent() && inHash.equals(existingHash.get())) {
                LOG.log(Level.INFO, "Returning cached result with ETag");
                return ResponseEntity.status(304)
                        .build();
            } else {
                LOG.log(Level.WARNING, "Existing hash not found for if-none-match value {0}", inHash);
            }
        }
        LOG.log(Level.INFO, "Cache miss on product id {0}", productId);
        // Not found in cache -- calculate hash and return value
        Optional<Product> foundProduct = Arrays.stream(Product.DEMO_PRODUCTS)
                .filter(product -> product.getId().equals(productId)).findFirst();
        String hash;
        if (foundProduct.isPresent()) {
           Product fp = foundProduct.get();
           hash = Integer.valueOf(fp.hashCode()).toString();
           productCache.putHashForId(productId, hash);
        } else {
            hash = "";
        }
        return foundProduct.map(product -> ResponseEntity.ok()
                        .eTag(hash)
                        .body(product)
                )
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
