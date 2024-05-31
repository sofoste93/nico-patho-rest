package com.sofoste.repository;

import com.sofoste.model.Firm;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FirmRepository implements PanacheRepository<Firm> {
    public List<Firm> findByName(String name) {
        return list("LOWER(name) = LOWER(?1)", name);
    }

    public List<Firm> search(String query) {
        String searchQuery = "%" + query.toLowerCase() + "%";
        return list("LOWER(name) like ?1 or LOWER(headquarters) like ?1", searchQuery);
    }
}
