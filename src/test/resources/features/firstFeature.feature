Feature: Validating response for this registration API

@testPost
  Scenario: Title of your scenario
    Given a maximal post request "qubePostUploadWrapper"
    And request field "name" is "Virender"
    And request field "size" is "Singh"
    And request field "hash" is "simpleuser001"
    When "demoApiEndpoint" is called
    And gets a successful response
    And the response field "FaultId" is "User already exists"
    And the response field "fault" is "FAULT_USER_ALREADY_EXISTS"

@testGet    
Scenario: Title of your scenario
    Given a maximal get request "qubeGetUploadWrapper"
    And request field "FirstName" is "Virender"
    And request field "LastName" is "Singh"
    And request field "UserName" is "simpleuser001"
    And request field "Password" is "password1"
    And request field "Email" is "someuser@gmail.com"
    When "qubeGetUpload" is called
    And gets a successful response
    And the response field "FaultId" is "User already exists"
    And the response field "fault" is "FAULT_USER_ALREADY_EXISTS"
