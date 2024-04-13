package com.company.search_service_for_ecommerce.service;

import com.company.search_service_for_ecommerce.exceptions.NotFoundException;
import com.company.search_service_for_ecommerce.models.Brand;
import com.company.search_service_for_ecommerce.models.Category;
import com.company.search_service_for_ecommerce.models.Product;
import com.company.search_service_for_ecommerce.strategy.searchStrategy.SearchStrategy;
import com.company.search_service_for_ecommerce.utils.StorageUtils;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ISearchServiceImpl implements ISearchService {

    @Override
    public List<Product> search(SearchStrategy searchStrategy, String searchParam) {
        return searchStrategy.search(searchParam);
    }
}
