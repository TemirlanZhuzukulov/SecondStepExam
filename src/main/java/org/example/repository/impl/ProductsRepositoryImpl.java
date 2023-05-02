package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.config.HiberbernateConfig;
import org.example.entity.Products;
import org.example.entity.Shop;
import org.example.repository.ProductsRepository;

import java.util.List;

public class ProductsRepositoryImpl implements ProductsRepository {
    EntityManager entityManager = HiberbernateConfig.getEntityManager();
    public String saveProducts(Products products) {
        entityManager.getTransaction().begin();
        entityManager.persist(products);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "is saved";
    }

    public Products updateShopById(Long id, Products products) {
        entityManager.getTransaction().begin();
        Products products1 = entityManager.find(Products.class, id);
        products1.setName(products.getName());
        entityManager.getTransaction().commit();
        entityManager.close();
        return products;
    }

    public List<Products> getAllProduct() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select  c from Products c");
        List<Products> productsList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return productsList;
    }

    public void deleteProductById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Products.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(" successfully deleted");
    }

    public Products getProductByShopId(Long productsId) {
        entityManager.getTransaction().begin();
        Products products= entityManager.find(Products.class, productsId);
        entityManager.createQuery("select s from Products  s join Products p on s.id=p.id where p.id=?1",
                        Shop.class).
                setParameter(1, productsId).getSingleResult();
        return products;
    }
}
