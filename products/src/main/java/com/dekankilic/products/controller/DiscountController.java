package com.dekankilic.products.controller;

import com.dekankilic.products.dto.DiscountResponseDto;
import com.dekankilic.products.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/discounts")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;

    @GetMapping
    public ResponseEntity<DiscountResponseDto> getDiscount(Long productId, String code) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(discountService.getDiscount(productId, code));
    }
}
