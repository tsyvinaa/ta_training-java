
Feature: Login functionality

  Scenario: UC-1 - Empty credentials
    Given I open SauceDemo website
    When I login with username "" and password ""
    Then I should see error message "Epic sadface: Username is required"

  Scenario: UC-2 - Missing password
    Given I open SauceDemo website
    When I login with username "standard_user" and password ""
    Then I should see error message "Epic sadface: Password is required"

  Scenario: UC-3 - Successful login
    Given I open SauceDemo website
    When I login with username "standard_usser" and password "secret_sauce"
    Then I should be redirected to the inventory page
