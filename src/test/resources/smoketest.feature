Feature: Smoke Test


  Scenario: Successful login with valid credentials
    Given User opens home page
    And User move to sign in page
    And User enter email
    And User enter password
    Then User should see a welcome message

    @Smoke
    Scenario: User search a product
      Given User opens home page
      And User move to sign in page
      And User enter email
      And User enter password
      Then User should see a welcome message
      When User search product "Macbook air 13"
      And User click search button
      Then User should verify correct result "Macbook air 13"

  @Smoke
  Scenario: User adds product to the cart
    Given User opens home page
    And User move to sign in page
    And User enter email
    And User enter password
    Then User should see a welcome message
    When User search product "Macbook air 13"
    And User click search button
    Then User should verify correct result "Macbook air 13"
    And User select first product from results
    And User should verify that product is in stock
    And User adds product to cart
    Then User should see a successful message
