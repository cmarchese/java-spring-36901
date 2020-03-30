package com.eduit;

import com.eduit.config.AppConfig;
import com.eduit.model.Product;
import com.eduit.repository.ProductRepositoryWithoutAop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepositoryWithoutAop productRepositoryWithoutAop = context.getBean(ProductRepositoryWithoutAop.class);

        Product product = new Product("PS3", "Consola");

        productRepositoryWithoutAop.saveProduct(product);

        System.out.println("Imprimiendo lista de productos " + productRepositoryWithoutAop.getProducts());

        productRepositoryWithoutAop.getProducts().stream().map(p -> p.getId()).forEach(id -> {
            System.out.println("Buscando producto por id e imprimiendolo uno por uno " + productRepositoryWithoutAop.getProduct(id));
        });
    }
}
