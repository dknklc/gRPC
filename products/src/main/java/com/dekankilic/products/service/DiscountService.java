package com.dekankilic.products.service;

import com.dekankilic.grpc.DiscountRequest;
import com.dekankilic.grpc.DiscountResponse;
import com.dekankilic.products.dto.DiscountResponseDto;
import com.dekankilic.products.model.Product;
import com.dekankilic.products.service.grpc.DiscountGrpcService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountGrpcService discountGrpcService;
    private final ProductService productService;

    public DiscountResponseDto getDiscount(Long productId, String code) {
        Product product = productService.getById(productId);
        DiscountRequest discountRequest = DiscountRequest.newBuilder()
                .setCode(code)
                .setPrice(product.getPrice().floatValue())
                .setExternalCategoryId(product.getCategory().getId())
                .build();

        DiscountResponse discountResponse = discountGrpcService.getDiscount(discountRequest);

        return DiscountResponseDto.builder()
                .oldPrice(discountResponse.getOldPrice())
                .newPrice(discountResponse.getNewPrice())
                .code(discountResponse.getCode())
                .build();
    }
}
