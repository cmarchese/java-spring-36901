package com.eduit.springbootdataaop;

import com.eduit.springbootdataaop.model.Product;
import com.eduit.springbootdataaop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReadyEvent {

    @Autowired
    private ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void persist() {
        Product product = new Product("XBOX", "Console");

        productRepository.save(product);

        System.out.println("Imprimiendo lista de productos " + productRepository.findAll());

        productRepository.findAll().stream().map(Product::getId).forEach(id -> {
            System.out.println("Buscando producto por id e imprimiendolo uno por uno " + productRepository.findById(id));
        });

        System.out.println("");
    }
}
