package com.eduit;

import com.eduit.config.AppConfig;
import com.eduit.model.Product;
import com.eduit.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepositoryWithoutAop = context.getBean(ProductRepository.class);

        Product product = new Product("PS3", "Consola");

        productRepositoryWithoutAop.save(product);

        System.out.println("Imprimiendo lista de productos " + productRepositoryWithoutAop.findAll());

        productRepositoryWithoutAop.findAll().stream().map(Product::getId).forEach(id -> {
            System.out.println("Buscando producto por id e imprimiendolo uno por uno " + productRepositoryWithoutAop.findById(id));
        });

        System.out.println("");
    }
}
