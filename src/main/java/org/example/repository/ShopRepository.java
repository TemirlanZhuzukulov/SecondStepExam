package org.example.repository;

import org.example.entity.Shop;

import java.util.List;

public interface ShopRepository {
    String saveShops(Shop shop);
    Shop updateShopById(Long id, Shop shop);
    List<Shop> getAllShop();
    void  deleteShopById(Long id);

    Shop getShopByProductsId(Long productsId);
}
