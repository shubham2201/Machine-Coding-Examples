package com.company.search_service_for_ecommerce.service;

import com.company.search_service_for_ecommerce.models.Category;

public interface CategoryService {

    public Category createCategory(String name);

    public Category updateCategory(String id, String name);

    public Category getCategory(String categoryId);

    public void deleteCategory(String categoryId);
}
