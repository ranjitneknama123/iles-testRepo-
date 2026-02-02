Feature: Login

  Background:
  Given user is on login page

  @smoke @sanity
  Scenario: Successful login
    When user enters username "standard_user" and password "secret_sauce"
    And clicks login button

  @sanity
  Scenario: Successful home page
    When user enters username "standard_user" and password "secret_sauce"
    And clicks login button
    Then user should see dashboard