package org.example.service.serviceImpl;

import org.example.entity.Products;
import org.example.repository.ProductsRepository;
import org.example.repository.impl.ProductsRepositoryImpl;
import org.example.service.ProductsService;

import java.util.List;

public class ProductsServiceImpl implements ProductsService {
      ProductsRepository productsRepository = new ProductsRepositoryImpl();

    @Override
    public String saveProducts(Products products) {
       return productsRepository.saveProducts(products) ;
    }

    @Override
    public Products updateShopById(Long id, Products products) {
        return productsRepository.updateShopById(id,products);
    }

    @Override
    public List<Products> getAllProduct() {
        return productsRepository.getAllProduct();
    }

    @Override
    public void deleteProductById(Long id) {
           productsRepository.deleteProductById(id);
    }

    @Override
    public Products getProductByShopId(Long productsId) {
        return productsRepository.getProductByShopId(productsId);
    }
}
