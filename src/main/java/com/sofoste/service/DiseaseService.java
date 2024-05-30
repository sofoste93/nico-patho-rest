package com.sofoste.service;

import com.sofoste.model.Disease;
import com.sofoste.repository.DiseaseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DiseaseService {

    @Inject
    DiseaseRepository diseaseRepository;

    @Transactional
    public Disease saveDisease(Disease disease) {
        if (disease.getId() == null) {
            diseaseRepository.persist(disease);
        } else {
            disease = diseaseRepository.getEntityManager().merge(disease);
        }
        return disease;
    }

    public List<Disease> findAllDiseases() {
        return diseaseRepository.listAll();
    }

    public Disease findDiseaseById(Long id) {
        return diseaseRepository.findById(id);
    }

    @Transactional
    public Disease updateDisease(Long id, Disease disease) {
        Disease existingDisease = diseaseRepository.findById(id);
        if (existingDisease != null) {
            existingDisease.setName(disease.getName());
            existingDisease.setDescription(disease.getDescription());
            return existingDisease;
        }
        return null;
    }

    @Transactional
    public void deleteDisease(Long id) {
        diseaseRepository.deleteById(id);
    }

    public List<Disease> searchDiseases(String query) {
        return diseaseRepository.find("name like ?1 or description like ?1", "%" + query + "%").list();
    }
}
