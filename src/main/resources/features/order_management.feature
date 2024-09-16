Feature: Order Management
  As a user
  I want to manage orders and products
  So that I can keep track of orders and products in the system

  Scenario: Create a new product
    Given I have product details
    When I create a new product
    Then the product should be added to the system

  Scenario: Create a new order
    Given I have order details with products
    When I create a new order
    Then the order should be added to the system
