package com.sofoste.repository;

import com.sofoste.model.Disease;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class DiseaseRepository implements PanacheRepository<Disease> {
    public List<Disease> findByName(String name) {
        return list("name", name);
    }
}
