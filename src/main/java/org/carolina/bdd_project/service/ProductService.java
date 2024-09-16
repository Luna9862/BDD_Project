package org.carolina.bdd_project.service;

import org.carolina.bdd_project.model.Product;
import org.carolina.bdd_project.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Read
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Update
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // List all
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
