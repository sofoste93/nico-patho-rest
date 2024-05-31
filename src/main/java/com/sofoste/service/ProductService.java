package com.sofoste.service;

import com.sofoste.model.Product;
import com.sofoste.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Transactional
    public Product saveProduct(Product product) {
        if (product.getId() == null) {
            productRepository.persist(product);
        } else {
            product = productRepository.getEntityManager().merge(product);
        }
        return product;
    }

    public List<Product> findAllProducts() {
        return productRepository.listAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id);
        if (existingProduct != null) {
            existingProduct.setBrandName(product.getBrandName());
            existingProduct.setNicotineContent(product.getNicotineContent());
            existingProduct.setTarContent(product.getTarContent());
            existingProduct.setCondensateContent(product.getCondensateContent());
            existingProduct.setFirm(product.getFirm());
            return existingProduct;
        }
        return null;
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> searchProducts(String query) {
        return productRepository.find("brandName like ?1 or firm.name like ?1", "%" + query + "%").list();
    }
}
