package com.sofoste.service;

import com.sofoste.model.ProductDisease;
import com.sofoste.repository.ProductDiseaseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductDiseaseService {

    @Inject
    ProductDiseaseRepository productDiseaseRepository;

    @Transactional
    public ProductDisease saveProductDisease(ProductDisease productDisease) {
        if (productDisease.getId() == null) {
            productDiseaseRepository.persist(productDisease);
        } else {
            productDisease = productDiseaseRepository.getEntityManager().merge(productDisease);
        }
        return productDisease;
    }

    public List<ProductDisease> findAllProductDiseases() {
        return productDiseaseRepository.listAll();
    }

    public ProductDisease findProductDiseaseById(Long id) {
        return productDiseaseRepository.findById(id);
    }

    @Transactional
    public ProductDisease updateProductDisease(Long id, ProductDisease productDisease) {
        ProductDisease existingProductDisease = productDiseaseRepository.findById(id);
        if (existingProductDisease != null) {
            existingProductDisease.setProduct(productDisease.getProduct());
            existingProductDisease.setDisease(productDisease.getDisease());
            existingProductDisease.setRiskLevel(productDisease.getRiskLevel());
            return existingProductDisease;
        }
        return null;
    }

    @Transactional
    public void deleteProductDisease(Long id) {
        productDiseaseRepository.deleteById(id);
    }

    public List<ProductDisease> findByProductId(Long productId) {
        return productDiseaseRepository.findByProductId(productId);
    }

    public List<ProductDisease> findByDiseaseId(Long diseaseId) {
        return productDiseaseRepository.findByDiseaseId(diseaseId);
    }
}
