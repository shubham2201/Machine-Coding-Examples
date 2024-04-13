package com.company.search_service_for_ecommerce.service;

import com.company.search_service_for_ecommerce.models.Brand;
import com.company.search_service_for_ecommerce.models.Category;
import com.company.search_service_for_ecommerce.models.Product;

public interface ProductService {

    public Product createProduct(String name, Category category, Brand brand);

    public Product updateProduct(String id, String name);

    public Product getProduct(String productId);

    public void deleteProduct(String productId);
}
