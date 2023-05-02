package org.example.service;

import org.example.entity.Shop;

import java.util.List;

public interface ShopService {
    String saveShops(Shop shop);
    Shop updateShopById(Long id, Shop shop);
    List<Shop> getAllShop();
    void  deleteShopById(Long id);

    Shop getShopByProductsId(Long productsId);
}
