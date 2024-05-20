package com.sofoste.repository;

import com.sofoste.model.Firm;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FirmRepository implements PanacheRepository<Firm> {
    public List<Firm> findByHeadquarters(String headquarters) {
        return list("headquarters", headquarters);
    }
}
