Feature: Validating response for this registration API


  Scenario: Calling post upload API
    Given a maximal post request "qubePostUploadWrapper"
    And add generated token "generated_Token" to url
    And request field "name" is "Automation Challenge"
    And request field "size" is "40"
    And request field "hash" is "zxy"
    When "qubePostUpload" is called
    And gets a successful response
    And the response field "FaultId" is "User already exists"
    And the response field "fault" is "FAULT_USER_ALREADY_EXISTS"

@testGet    
Scenario: Calling get upload API
    Given a maximal get request "qubeGetUploadWrapper"
    And add generated token "generated_Token" to url
    When "qubeGetUpload" is called
    And gets a successful response
    And the response field "FaultId" is "User already exists"
    And the response field "fault" is "FAULT_USER_ALREADY_EXISTS"
