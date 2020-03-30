/*
package com.eduit.repository;

import com.eduit.aspect.PerformanceCheckAble;
import com.eduit.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryWithAop implements ProductRepository {

    private SessionFactory sessionFactory;

    public ProductRepositoryWithAop(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT p FROM Product p";

    @Transactional
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.createQuery(GET_ALL_PRODUCTS_QUERY, Product.class);
        return new ArrayList<>(query.getResultList());
    }

    @Transactional
    public Product findById(Long id) {
        Session session = sessionFactory.getCurrentSession();;
        return session.get(Product.class, id);
    }

    @PerformanceCheckAble
    @Transactional
    public void save(Product product) {
        Session session = session = sessionFactory.getCurrentSession();;
        session.persist(product);
    }
}
*/
