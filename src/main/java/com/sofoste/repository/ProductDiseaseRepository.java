package com.sofoste.repository;

import com.sofoste.model.ProductDisease;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductDiseaseRepository implements PanacheRepository<ProductDisease> {
}
