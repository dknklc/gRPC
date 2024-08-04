package com.dekankilic.discounts.repository;

import com.dekankilic.discounts.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByExternalId(String externalId);
}
