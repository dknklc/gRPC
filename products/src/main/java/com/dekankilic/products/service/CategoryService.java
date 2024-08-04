package com.dekankilic.products.service;

import com.dekankilic.products.model.Category;
import com.dekankilic.products.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category add(Category category) {
        return categoryRepository.save(category);
    }
}
