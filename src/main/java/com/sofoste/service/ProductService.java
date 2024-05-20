package com.sofoste.service;

import com.sofoste.model.Product;
import com.sofoste.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Transactional
    public Product saveProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product updateProduct(Long id, Product product) {
        Product entity = productRepository.findById(id);
        if (entity != null) {
            entity.setBrandName(product.getBrandName());
            entity.setNicotineContent(product.getNicotineContent());
            entity.setTarContent(product.getTarContent());
            entity.setCondensateContent(product.getCondensateContent());
        }
        return entity;
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}