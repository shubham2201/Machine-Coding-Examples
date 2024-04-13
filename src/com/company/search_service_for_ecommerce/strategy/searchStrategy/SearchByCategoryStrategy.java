package com.company.search_service_for_ecommerce.strategy.searchStrategy;

import com.company.search_service_for_ecommerce.exceptions.NotFoundException;
import com.company.search_service_for_ecommerce.models.Brand;
import com.company.search_service_for_ecommerce.models.Category;
import com.company.search_service_for_ecommerce.models.Product;
import com.company.search_service_for_ecommerce.utils.StorageUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchByCategoryStrategy implements SearchStrategy{

    private StorageUtils storageUtils;

    public SearchByCategoryStrategy(StorageUtils storageUtils) {
        this.storageUtils = storageUtils;
    }

    @Override
    public List<Product> search(String categoryId) {
        Optional<Category> category = storageUtils.fetchCategoryById(categoryId);
        if (category.isEmpty()) {
            throw new NotFoundException("No category found with id: " + categoryId);
        }
        return storageUtils.getProducts().stream()
                .filter(product -> product.getCategory().getId().equals(categoryId))
                .collect(Collectors.toList());
    }
}
