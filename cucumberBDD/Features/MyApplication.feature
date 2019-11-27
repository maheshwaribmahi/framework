Feature: Test gmail smoke scenario
 
  Scenario: Test login with valid credentials
    Given Open Chrome and start application
    When I enter valid "maheshwarib83@gmail.com" and valid "8970305187"
    Then user should be able to login successfully
   
