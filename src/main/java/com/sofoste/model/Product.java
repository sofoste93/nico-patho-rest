package com.sofoste.model;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 255)
    private String brandName;

    @NotNull
    private double nicotineContent;

    @NotNull
    private double tarContent;

    @NotNull
    private double condensateContent; // Kondensat

    @ManyToOne
    @JoinColumn(name = "firm_id", foreignKey = @ForeignKey(name = "fk_firm_id"))
    private Firm firm;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getNicotineContent() {
        return nicotineContent;
    }

    public void setNicotineContent(double nicotineContent) {
        this.nicotineContent = nicotineContent;
    }

    public double getTarContent() {
        return tarContent;
    }

    public void setTarContent(double tarContent) {
        this.tarContent = tarContent;
    }

    public double getCondensateContent() {
        return condensateContent;
    }

    public void setCondensateContent(double condensateContent) {
        this.condensateContent = condensateContent;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }
}
