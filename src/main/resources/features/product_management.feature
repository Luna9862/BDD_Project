Feature: Product Management

  Scenario: Create a new product
    Given I have product details with name "Laptop" and price 999.99
    When I add the product to the system
    Then the product should be available in the system
    And the product price should be 999.99

  Scenario: Update a product price
    Given a product with name "Laptop" exists in the system
    When I update the product price to 899.99
    Then the product price should now be 899.99

  Scenario: Delete a product
    Given a product with name "Laptop" exists in the system
    When I delete the product
    Then the product should no longer be available in the system
