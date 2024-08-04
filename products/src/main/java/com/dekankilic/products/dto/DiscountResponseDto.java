package com.dekankilic.products.dto;

import lombok.Builder;

@Builder
public record DiscountResponseDto(
        float oldPrice,
        float newPrice,
        String code
) {
}
