package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.config.HiberbernateConfig;
import org.example.entity.Shop;
import org.example.repository.ShopRepository;

import java.util.List;

public class ShopRepositoryImpl implements ShopRepository {
    EntityManager entityManager = HiberbernateConfig.getEntityManager();

    public String saveShops(Shop shop) {
        entityManager.getTransaction().begin();
        entityManager.persist(shop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "is saved";
    }

    public Shop updateShopById(Long id, Shop shop) {
        entityManager.getTransaction().begin();
        Shop shop1 = entityManager.find(Shop.class, id);
        shop1.setName(shop.getName());
        shop1.setAddress(shop.getAddress());
        entityManager.getTransaction().commit();
        entityManager.close();
        return shop;

    }

    public List<Shop> getAllShop() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select  c from Shop c");
        List<Shop> shops = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return shops;

    }

    public void deleteShopById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Shop.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(" successfully deleted");
    }

    public Shop getShopByProductsId(Long productsId) {
        entityManager.getTransaction().begin();
        Shop shop = entityManager.find(Shop.class, productsId);
        entityManager.createQuery("select s from Shop  s join Products p on s.id=p.id where p.id=?1",
                        Shop.class).
                setParameter(1, productsId).getSingleResult();
        return shop;
    }
}
