Feature: Purchase product from client application

  Scenario: Login and purchase a product

    Given the user is on the client application login page
    When the user logs in with valid credentials
    And the user selects the product "ZARA COAT 3"
    And the user proceeds to checkout
    And the user selects country "India"
    Then the user should be able to complete the checkout details