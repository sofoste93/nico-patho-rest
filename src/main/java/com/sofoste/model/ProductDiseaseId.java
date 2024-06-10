package com.sofoste.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductDiseaseId implements Serializable {
    private Long productId;
    private Long diseaseId;

    // Getters, setters, hashCode, equals
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDiseaseId that = (ProductDiseaseId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(diseaseId, that.diseaseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, diseaseId);
    }
}
