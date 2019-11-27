Feature: Test gmail smoke scenario
 
  Scenario Outline: Test login with valid credentials
    Given Open Chrome and start application
    When I enter valid "<username>" and valid "<password>"
    Then user should be able to login successfully
    Then application should be closed
    
 Examples:
    | username | password |
    | maheshwarib83@gmail.com | 8970305187 |
   	| maheshwarib84@gmail.com | 8970305187 |
    | missmaheshwarib1992@gmail.com | 1992|
