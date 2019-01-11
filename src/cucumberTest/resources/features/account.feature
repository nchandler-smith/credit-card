Feature: Account Management
  As a merchant (FinTech customer), I want a process to create new accounts, so that I can issue and assign new credit cards.

  Scenario: Account has a card number and credit limit
    Given a card holder Name: "Steve Goliath", SSN: "123-45-6788", Merchant Name: "Target"
    When a request to create a new card is made
    Then a card number is returned
    And a credit limit of 10000.0 is assigned.