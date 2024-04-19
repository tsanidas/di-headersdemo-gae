package com.diveinsoft.blog.headers.product;

import com.diveinsoft.blog.headers.models.Product;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/products")
public class ProductController {
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
}
