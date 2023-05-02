package org.example;

import org.example.config.HiberbernateConfig;
import org.example.entity.Shop;
import org.example.service.ShopService;
import org.example.service.serviceImpl.ShopServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        //HiberbernateConfig.getEntityManager();

        ShopService service = new ShopServiceImpl();
////        service.saveShops(new Shop("Bereke","Chuy"));
//        //service.updateShopById(2L,new Shop("Dostor","Auezova"));
//        System.out.println(service.getAllShop());
    }
}
