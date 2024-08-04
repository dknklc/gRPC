package com.dekankilic.discounts.repository;

import com.dekankilic.discounts.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    Optional<Discount> findByCodeAndCategoryId(String code, Long categoryId);

}
