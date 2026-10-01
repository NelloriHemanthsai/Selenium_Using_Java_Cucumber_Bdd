Feature: Client application shopping

  Scenario: Login and add product to cart

    Given I open the client application

    When I login with valid credentials

    And I add product "ZARA COAT 3" to the cart

    And I open the cart

    And I click on checkout

    And I select country "IND"

    Then the country should be selected