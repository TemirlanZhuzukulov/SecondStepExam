package org.example.service;

import org.example.entity.Products;

import java.util.List;

public interface ProductsService {
    String saveProducts(Products products);
    Products updateShopById(Long id, Products products);
    List<Products> getAllProduct();
    void  deleteProductById(Long id);

    Products getProductByShopId(Long productsId);
}
