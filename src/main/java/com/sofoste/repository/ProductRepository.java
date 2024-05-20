package com.sofoste.repository;

import com.sofoste.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    public List<Product> findByType(String type) {
        return list("type", type);
    }
}