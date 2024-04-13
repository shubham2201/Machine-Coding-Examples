package com.company.search_service_for_ecommerce.strategy.searchStrategy;

import com.company.search_service_for_ecommerce.models.Product;

import java.util.List;

public interface SearchStrategy {

    public List<Product> search(String id);
}
