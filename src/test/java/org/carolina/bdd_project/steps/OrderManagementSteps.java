package org.carolina.bdd_project.steps;

import org.carolina.bdd_project.BddProjectApplication;
import org.carolina.bdd_project.model.Order;
import org.carolina.bdd_project.model.Product;
import org.carolina.bdd_project.repository.OrderRepository;
import org.carolina.bdd_project.repository.ProductRepository;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = BddProjectApplication.class)
public class OrderManagementSteps {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    private Product product;
    private Order order;

    @Given("I have product details")
    public void i_have_product_details() {
        product = new Product();
        product.setName("Sample Product");
        product.setPrice(9.99);
    }

    @When("I create a new product")
    public void i_create_a_new_product() {
        product = productRepository.save(product);
    }

    @Then("the product should be added to the system")
    public void the_product_should_be_added_to_the_system() {
        assertNotNull(product.getId());
    }

    @Given("I have order details with products")
    public void i_have_order_details_with_products() {
        order = new Order();
        order.setCustomerName("John Doe");

        Product product1 = new Product();
        product1.setName("Product A");
        product1.setPrice(19.99);
        product1 = productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product B");
        product2.setPrice(29.99);
        product2 = productRepository.save(product2);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        order.setProducts(products);
    }

    @When("I create a new order")
    public void i_create_a_new_order() {
        order = orderRepository.save(order);
    }

    @Then("the order should be added to the system")
    public void the_order_should_be_added_to_the_system() {
        assertNotNull(order.getId());
    }
}
