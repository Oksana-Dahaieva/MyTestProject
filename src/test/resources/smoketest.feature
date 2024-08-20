Feature: Smoke Test

  Scenario: User sign in account
    Given User opens home page
    And User move to sign in page
    And User enter email
    And User enter password
    Then User can see header with message 'Hello, Oksana'