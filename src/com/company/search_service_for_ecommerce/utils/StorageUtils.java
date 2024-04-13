package com.company.search_service_for_ecommerce.utils;

import com.company.search_service_for_ecommerce.models.Brand;
import com.company.search_service_for_ecommerce.models.Category;
import com.company.search_service_for_ecommerce.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class StorageUtils {

    private List<Brand> brands;

    private List<Category> categories;

    private List<Product> products;

    /**
     * Brands CRUD
     */

    public void createBrand(Brand brand) {
        brands.add(brand);
    }

    public void updateBrand(Brand updatedBrand) {
        brands.removeIf(brand -> brand.getId().equals(updatedBrand.getId()));
        brands.add(updatedBrand);
    }

    public Optional<Brand> fetchBrandById(String brandId) {
        return brands.stream().filter(brand1 -> brand1.getId().equals(brandId)).findFirst();
    }

    public void deleteBrandById(String brandId) {
        brands.removeIf(brand -> brand.getId().equals(brandId));
    }

    /**
     * Category
     */

    public void createCategory(Category category) {
        categories.add(category);
    }

    public void updateCategory(Category updatedCategory) {
        categories.removeIf(brand -> brand.getId().equals(updatedCategory.getId()));
        categories.add(updatedCategory);
    }

    public Optional<Category> fetchCategoryById(String categoryId) {
        return categories.stream().filter(category -> category.getId().equals(categoryId)).findFirst();
    }

    public void deleteCategoryById(String categoryId) {
        categories.removeIf(category -> category.getId().equals(categoryId));
    }

    /**
     * Products CRUD
     */

    public void createProducts(Product product) {
        products.add(product);
    }

    public void updateProducts(Product updatedProduct) {
        products.removeIf(products -> products.getId().equals(updatedProduct.getId()));
        products.add(updatedProduct);
    }

    public Optional<Product> fetchProductById(String productId) {
        return products.stream().filter(products -> products.getId().equals(productId)).findFirst();
    }

    public void deleteProductById(String productId) {
        products.removeIf(products -> products.getId().equals(productId));
    }
}
