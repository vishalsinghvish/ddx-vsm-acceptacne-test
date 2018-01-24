Feature: Validating response for this registration API
  I want to use this template for my feature file

  Scenario: Title of your scenario
    Given a maximal request "demoRequestWrapper"
    And request field "FirstName" is "Virender"
    And request field "LastName" is "Singh"
    And request field "UserName" is "simpleuser001"
    And request field "Password" is "password1"
    And request field "Email" is "someuser@gmail.com"
    When "demoApiEndpoint" is called
    And gets a successful response
    And the response field "FaultId" is "User already exists"
    And the response field "fault" is "FAULT_USER_ALREADY_EXISTS"
