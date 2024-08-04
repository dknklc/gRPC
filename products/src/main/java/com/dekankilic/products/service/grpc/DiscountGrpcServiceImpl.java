package com.dekankilic.products.service.grpc;

import com.dekankilic.grpc.DiscountRequest;
import com.dekankilic.grpc.DiscountResponse;

import com.dekankilic.grpc.DiscountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DiscountGrpcServiceImpl implements DiscountGrpcService {

    private DiscountServiceGrpc.DiscountServiceBlockingStub discountServiceBlockingStub; // Ben bir kanal oluşturdum, bu kanaldan başka bir servise istek attım ve istek tamamlanıncaya kadar bekleyen stubdır.
    private ManagedChannel channel; // Karşıda ki servisin hostu ve portu ile bir channel oluşturmamız lazım.

    public DiscountGrpcServiceImpl(@Value("${discount.grpc.host}") String grpcHost, @Value("${discount.grpc.port}") int grpcPort) {

        channel = ManagedChannelBuilder.forAddress(grpcHost, grpcPort)
                .usePlaintext()
                .build();
    }

    @Override
    public DiscountResponse getDiscount(DiscountRequest discountRequest) {
        discountServiceBlockingStub = DiscountServiceGrpc.newBlockingStub(channel);
        DiscountResponse discountResponse = discountServiceBlockingStub.getDiscount(discountRequest);
        return discountResponse;
    }
}
