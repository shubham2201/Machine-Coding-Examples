package com.company.search_service_for_ecommerce.service;

import com.company.search_service_for_ecommerce.models.Product;
import com.company.search_service_for_ecommerce.strategy.searchStrategy.SearchStrategy;

import java.util.List;

public interface ISearchService {

    public List<Product> search(SearchStrategy searchStrategy, String searchParam);
}
