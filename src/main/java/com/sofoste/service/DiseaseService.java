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
        diseaseRepository.persist(disease);
        return disease;
    }

    public Disease findDiseaseById(Long id) {
        return diseaseRepository.findById(id);
    }

    public List<Disease> findAllDiseases(){
        return diseaseRepository.findAll().list();
    }

    @Transactional
    public Disease updateDisease(Long id, Disease disease) {
        Disease entity = diseaseRepository.findById(id);
        if(entity != null) {
            entity.setName(disease.getName());
            entity.setDescription(disease.getDescription());
        }
        return entity;
    }

    @Transactional
    public void deleteDisease(Long id) {
        diseaseRepository.deleteById(id);
    }
}
