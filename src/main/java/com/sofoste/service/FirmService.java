package com.sofoste.service;

import com.sofoste.model.Firm;
import com.sofoste.repository.FirmRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FirmService {

    @Inject
    FirmRepository firmRepository;

    @Transactional
    public Firm saveFirm(Firm firm) {
        firmRepository.persist(firm);
        return firm;
    }

    public Firm findFirmById(Long id) {
        return firmRepository.findById(id);
    }

    @Transactional
    public Firm updateFirm(Long id, Firm firm) {
        Firm entity = firmRepository.findById(id);
        if (entity != null) {
            entity.setName(firm.getName());
            entity.setHeadquarters(firm.getHeadquarters());
            entity.setAnnualRevenue(firm.getAnnualRevenue());
            entity.setAnnualTax(firm.getAnnualTax());
            entity.setAnnualProfit(firm.getAnnualProfit());
        }
        return entity;
    }

    @Transactional
    public void deleteFirm(Long id) {
        firmRepository.deleteById(id);
    }
}
