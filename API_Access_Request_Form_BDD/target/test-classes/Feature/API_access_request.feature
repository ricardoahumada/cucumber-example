Feature: API Access Request Form

Scenario: Submit a message via API Access Request Form
    Given I am on the api access request form page
    When I fill in the api access request form with valid details
    And I submit the api access request form
    Then I should see a success message