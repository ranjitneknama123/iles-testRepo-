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

  @DataTableTest
  Scenario: validate data table validation
    When I search the following items and validate results
      | items  | expectedMessages |
      | item1  | No results found |
      | item2  | Item available   |
      | item3  | Out of stock     |
      | item4  | No results found |
      | item5  | Item available   |
      | item6  | Out of stock     |
      | item7  | No results found |
      | item8  | Item available   |
      | item9  | Out of stock     |
      | item10 | No results found |


  @DataTableTest1
  Scenario: Validate single data table parameter test
    When I enter username and password into text field
      | username  | password  |
      | username1 | password1 |
      | username2 | password2 |
    When I on login page sign up form "<signup>"

  @parameterPractice
  Scenario: Validate all parameter
    When i am on the login page enter username as "ranjit123" and password as "password123"
    When user is not exisrting sign up form
      | signup    |
      | firstName |
      | lastName  |
      | mobileNo  |
      | email     |
    When user enter multiple column data
      | userNameHeader | passwordHeader |
      | userName1      | password1      |
      | userName2      | password2      |
      | userName3      | password3      |
      | userName4      | password4      |


  @sopractice
  Scenario Outline: Validate login with different date set
    When enter username as "<userName>" and password as "<password>" into text field check "<message>"
    Then validate message as "Successfully"
    Examples:
      | userName  | password  | message  |
      | userName1 | password1 | message1 |
      | userName2 | password2 | message2 |
      | userName3 | password3 | message3 |
      | userName4 | password4 | message4 |



