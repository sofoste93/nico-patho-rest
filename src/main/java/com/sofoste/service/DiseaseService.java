package com.sofoste.service;

import com.sofoste.model.Disease;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class DiseaseService {

    @Inject
    EntityManager entityManager;

    public Disease saveDisease(Disease disease) {
        entityManager.persist(disease);
        return disease;
    }

    public List<Disease> findAllDiseases() {
        return entityManager.createQuery("SELECT d FROM Disease d", Disease.class).getResultList();
    }

    public Disease findDiseaseById(Long id) {
        return entityManager.find(Disease.class, id);
    }

    public Disease updateDisease(Long id, Disease disease) {
        Disease existingDisease = entityManager.find(Disease.class, id);
        if (existingDisease != null) {
            existingDisease.setName(disease.getName());
            existingDisease.setDescription(disease.getDescription());
            entityManager.merge(existingDisease);
            return existingDisease;
        }
        return null;
    }

    public void deleteDisease(Long id) {
        Disease disease = entityManager.find(Disease.class, id);
        if (disease != null) {
            entityManager.remove(disease);
        }
    }

    public List<Disease> searchDiseases(String query) {
        return entityManager.createQuery("SELECT d FROM Disease d WHERE d.name LIKE :query OR d.description LIKE :query", Disease.class)
                .setParameter("query", "%" + query + "%")
                .getResultList();
    }
}
