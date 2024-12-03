Feature: As an app owner, I want to be able to request API access via a form so I can consume API data in my app.

Scenario: Submit a valid request via API Access Request Form
    Given I am on the api access request form page
    When I fill in the api access request form with valid details
    And I submit the api access request form
    Then I should see a success message

# Other scenarios
