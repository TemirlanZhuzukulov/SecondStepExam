package org.example.repository;

import org.example.entity.Products;
import org.example.entity.Shop;

import java.util.List;

public interface ProductsRepository {
    String saveProducts(Products products);
      Products updateShopById(Long id, Products products);
    List<Products> getAllProduct();
    void  deleteProductById(Long id);

    Products getProductByShopId(Long productsId);

}
