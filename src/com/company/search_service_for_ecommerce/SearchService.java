package com.company.search_service_for_ecommerce;

import com.company.search_service_for_ecommerce.exceptions.NotFoundException;
import com.company.search_service_for_ecommerce.models.Brand;
import com.company.search_service_for_ecommerce.models.Category;
import com.company.search_service_for_ecommerce.models.Product;
import com.company.search_service_for_ecommerce.service.*;
import com.company.search_service_for_ecommerce.strategy.searchStrategy.SearchByBrandStrategy;
import com.company.search_service_for_ecommerce.strategy.searchStrategy.SearchByCategoryStrategy;
import com.company.search_service_for_ecommerce.strategy.searchStrategy.SearchByProductName;
import com.company.search_service_for_ecommerce.strategy.searchStrategy.SearchStrategy;
import com.company.search_service_for_ecommerce.utils.StorageUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SearchService {

    public static void main(String[] args) {

        try {
            StorageUtils storageUtils = new StorageUtils(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            SearchStrategy byCategory = new SearchByCategoryStrategy(storageUtils);
            SearchStrategy byBrand = new SearchByBrandStrategy(storageUtils);
            SearchStrategy byProducatName= new SearchByProductName(storageUtils);
            BrandService brandService = new BrandServiceImpl(storageUtils);
            CategoryService categoryService = new CategoryServiceImpl(storageUtils);
            ProductService productService = new ProductServiceImpl(storageUtils);
            ISearchService searchService = new ISearchServiceImpl();

            Brand onePlus = brandService.createBrand("OnePlus");
            Category mobile = categoryService.createCategory("Mobile");
            Category laptop = categoryService.createCategory("Laptop");
            Product ce4 = productService.createProduct("CE 4", mobile, onePlus);
            Product nord4 = productService.createProduct("Nord 4", mobile, onePlus);
            Product NordLp1 = productService.createProduct("Nord Lp 1", laptop, onePlus);
            System.out.println(onePlus.toString());
            System.out.println(mobile.toString());
            System.out.println(ce4.toString());
            System.out.println(nord4.toString());
            System.out.println(NordLp1.toString());
            System.out.println(searchService.search(byBrand, onePlus.getId()).stream().map(Product::getName).collect(Collectors.toList()));
            System.out.println(searchService.search(byCategory, mobile.getId()).stream().map(Product::getName).collect(Collectors.toList()));
            System.out.println(searchService.search(byCategory, laptop.getId()).stream().map(Product::getName).collect(Collectors.toList()));
            System.out.println(searchService.search(byProducatName, "Nord 4").stream().map(Product::getName).collect(Collectors.toList()));
        } catch (NotFoundException ex) {
            System.out.println("Not found exception caught with message: " + ex.getMessage());
        }
    }
}
