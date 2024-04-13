package com.company.search_service_for_ecommerce.strategy.searchStrategy;

import com.company.search_service_for_ecommerce.models.Product;
import com.company.search_service_for_ecommerce.utils.StorageUtils;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByProductName implements SearchStrategy {

    private StorageUtils storageUtils;

    public SearchByProductName(StorageUtils storageUtils) {
        this.storageUtils = storageUtils;
    }

    @Override
    public List<Product> search(String name) {
        return storageUtils.getProducts().stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
