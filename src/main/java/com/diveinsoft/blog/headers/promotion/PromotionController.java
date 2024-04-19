package com.diveinsoft.blog.headers.promotion;

import com.diveinsoft.blog.headers.models.Promotion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    /**
     * Does not emit any specific cache control header.  Use any product ID.
     * @param productId
     * @return
     */
    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<List<Promotion>> getCurrentPromotions(@PathVariable String productId) {
        List<Promotion> foundPromos = Arrays.stream(Promotion.DEMO_PROMOTIONS)
                // A "real" API endpoint would filter by start date / end date
                .toList();
        return ResponseEntity.ok()
                .body(foundPromos);
    }
}
