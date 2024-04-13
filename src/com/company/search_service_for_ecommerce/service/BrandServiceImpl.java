package com.company.search_service_for_ecommerce.service;

import com.company.search_service_for_ecommerce.models.Brand;
import com.company.search_service_for_ecommerce.utils.StorageUtils;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class BrandServiceImpl implements BrandService{

    private StorageUtils storageUtils;

    @Override
    public Brand createBrand(String name) {
        Brand brand = new Brand(UUID.randomUUID().toString(), name);
        storageUtils.createBrand(brand);
        return brand;
    }
}
