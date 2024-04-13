package com.company.search_service_for_ecommerce.strategy.searchStrategy;

import com.company.search_service_for_ecommerce.exceptions.NotFoundException;
import com.company.search_service_for_ecommerce.models.Brand;
import com.company.search_service_for_ecommerce.models.Category;
import com.company.search_service_for_ecommerce.models.Product;
import com.company.search_service_for_ecommerce.utils.StorageUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchByBrandStrategy implements SearchStrategy {

    private StorageUtils storageUtils;

    public SearchByBrandStrategy(StorageUtils storageUtils) {
        this.storageUtils = storageUtils;
    }

    public List<Product> search(String brandId) {
        Optional<Brand> brand = storageUtils.fetchBrandById(brandId);
        if (brand.isEmpty()) {
            throw new NotFoundException("No brand found with id: " + brandId);
        }
        return storageUtils.getProducts().stream()
                .filter(product -> product.getBrand().getId().equals(brandId))
                .collect(Collectors.toList());
    }
}
