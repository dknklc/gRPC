package com.dekankilic.products.service.grpc;

import com.dekankilic.grpc.DiscountRequest;
import com.dekankilic.grpc.DiscountResponse;

public interface DiscountGrpcService {
    DiscountResponse getDiscount(DiscountRequest discountRequest); // The type DiscountResponse and DiscountRequest, also the method name getDiscount could be different than what we defined in Discount.proto file, but I do not want to use dto and mapper here.
}
