package org.carolina.bdd_project.steps;

import org.carolina.bdd_project.BddProjectApplication;
import org.carolina.bdd_project.model.Product;
import org.carolina.bdd_project.repository.ProductRepository;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;

import java.util.Optional;

@ContextConfiguration(classes = BddProjectApplication.class)
public class ProductManagementSteps {

    @Autowired
    private ProductRepository productRepository;

    private Product product;
    private Optional<Product> retrievedProduct;

    @Given("I have product details with name {string} and price {double}")
    public void i_have_product_details(String name, double price) {
        product = new Product();
        product.setName(name);
        product.setPrice(price);
    }

    @When("I add the product to the system")
    public void i_add_the_product_to_the_system() {
        product = productRepository.save(product);
    }

    @Then("the product should be available in the system")
    public void the_product_should_be_available_in_the_system() {
        retrievedProduct = productRepository.findById(product.getId());
        assertTrue(retrievedProduct.isPresent());
    }

    @Then("the product price should be {double}")
    public void the_product_price_should_be(double price) {
        assertEquals(price, retrievedProduct.get().getPrice(), 0.01);
    }

    @Given("a product with name {string} exists in the system")
    public void a_product_with_name_exists_in_the_system(String name) {
        product = new Product();
        product.setName(name);
        product.setPrice(100.00); // Default price for testing
        product = productRepository.save(product);
    }

    @When("I update the product price to {double}")
    public void i_update_the_product_price_to(double newPrice) {
        product.setPrice(newPrice);
        productRepository.save(product); // Update the product
    }

    @Then("the product price should now be {double}")
    public void the_product_price_should_now_be(double expectedPrice) {
        retrievedProduct = productRepository.findById(product.getId());
        assertTrue(retrievedProduct.isPresent());
        assertEquals(expectedPrice, retrievedProduct.get().getPrice(), 0.01);
    }

    @When("I delete the product")
    public void i_delete_the_product() {
        productRepository.deleteById(product.getId());
    }

    @Then("the product should no longer be available in the system")
    public void the_product_should_no_longer_be_available_in_the_system() {
        retrievedProduct = productRepository.findById(product.getId());
        assertFalse(retrievedProduct.isPresent());
    }
}
