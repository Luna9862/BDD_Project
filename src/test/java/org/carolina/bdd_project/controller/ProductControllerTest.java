package org.carolina.bdd_project.controller;

import org.carolina.bdd_project.model.Product;
import org.carolina.bdd_project.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private Product product;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
        product.setId(1L);
        product.setName("Laptop");
        product.setPrice(999.99);
    }

    @Test
    public void testCreateProduct() {
        when(productService.saveProduct(any(Product.class))).thenReturn(product);
        Product createdProduct = productController.createProduct(product);
        assertNotNull(createdProduct);
        assertEquals("Laptop", createdProduct.getName());
        assertEquals(999.99, createdProduct.getPrice());
        verify(productService, times(1)).saveProduct(any(Product.class));
    }

    @Test
    public void testGetProduct() {
        when(productService.getProductById(1L)).thenReturn(product);
        Product foundProduct = productController.getProduct(1L);
        assertNotNull(foundProduct);
        assertEquals("Laptop", foundProduct.getName());
        assertEquals(999.99, foundProduct.getPrice());
        verify(productService, times(1)).getProductById(1L);
    }
}
