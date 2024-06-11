package com.sofoste.repository;

import com.sofoste.model.ProductDisease;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProductDiseaseRepository implements PanacheRepository<ProductDisease> {
    public List<ProductDisease> findByProductId(Long productId) {
        return list("product.id", productId);
    }

    public List<ProductDisease> findByDiseaseId(Long diseaseId) {
        return list("disease.id", diseaseId);
    }
}
