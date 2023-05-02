package org.example.service.serviceImpl;

import org.example.entity.Shop;
import org.example.repository.ShopRepository;
import org.example.repository.impl.ShopRepositoryImpl;
import org.example.service.ShopService;

import java.util.List;

public class ShopServiceImpl implements ShopService {
   ShopRepository shopRepository = new ShopRepositoryImpl();

    @Override
    public String saveShops(Shop shop) {
       return   shopRepository.saveShops(shop);

    }

    @Override
    public Shop updateShopById(Long id, Shop shop) {
        return shopRepository.updateShopById(id,shop);
    }

    @Override
    public List<Shop> getAllShop() {
        return shopRepository.getAllShop();
    }

    @Override
    public void deleteShopById(Long id) {
      shopRepository.deleteShopById(id);
    }

    @Override
    public Shop getShopByProductsId(Long productsId) {
        return shopRepository.getShopByProductsId(productsId);
    }
}
