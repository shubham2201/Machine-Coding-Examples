package com.company.search_service_for_ecommerce.service;

import com.company.search_service_for_ecommerce.exceptions.NotFoundException;
import com.company.search_service_for_ecommerce.models.Category;
import com.company.search_service_for_ecommerce.utils.StorageUtils;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private StorageUtils storageUtils;

    @Override
    public Category createCategory(String name) {
        Category category = new Category(UUID.randomUUID().toString(), name);
        storageUtils.createCategory(category);
        return category;
    }

    @Override
    public Category updateCategory(String id, String name) {
        Optional<Category> category = storageUtils.fetchCategoryById(id);
        if (category.isEmpty()) {
            throw new NotFoundException("No category found with id: " + id);
        }
        category.get().setName(name);
        storageUtils.updateCategory(category.get());
        return category.get();
    }

    @Override
    public Category getCategory(String categoryId) {
        Optional<Category> category = storageUtils.fetchCategoryById(categoryId);
        if (category.isEmpty()) {
            throw new NotFoundException("No category found with id: " + categoryId);
        }
        return category.get();
    }

    @Override
    public void deleteCategory(String categoryId) {
        Optional<Category> category = storageUtils.fetchCategoryById(categoryId);
        if (category.isEmpty()) {
            throw new NotFoundException("No category found with id: " + categoryId);
        }
        storageUtils.deleteCategoryById(categoryId);
    }
}
