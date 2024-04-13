package com.company.search_service_for_ecommerce.service;

import com.company.search_service_for_ecommerce.exceptions.NotFoundException;
import com.company.search_service_for_ecommerce.models.Brand;
import com.company.search_service_for_ecommerce.models.Category;
import com.company.search_service_for_ecommerce.models.Product;
import com.company.search_service_for_ecommerce.utils.StorageUtils;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private StorageUtils storageUtils;

    @Override
    public Product createProduct(String name, Category category, Brand brand) {
        Product product = new Product(UUID.randomUUID().toString(), name, category, brand);
        storageUtils.createProducts(product);
        return product;
    }

    @Override
    public Product updateProduct(String id, String name) {
        Optional<Product> product = storageUtils.fetchProductById(id);
        if (product.isEmpty()) {
            throw new NotFoundException("No product found with id: " + id);
        }
        product.get().setName(name);
        return product.get();
    }

    @Override
    public Product getProduct(String productId) {
        Optional<Product> product = storageUtils.fetchProductById(productId);
        if (product.isEmpty()) {
            throw new NotFoundException("No product found with id: " + productId);
        }
        return product.get();
    }

    @Override
    public void deleteProduct(String productId) {
        Optional<Product> product = storageUtils.fetchProductById(productId);
        if (product.isEmpty()) {
            throw new NotFoundException("No product found with id: " + productId);
        }
        storageUtils.deleteProductById(productId);
    }
}
