Feature: Validating response for this registration API

@test
  Scenario: Title of your scenario
    Given a maximal post request "qube"
    #And add generated token "ea67efd9-020a-490c-b76b-814c33925ee6" to url
    And request field "name" is "File1"
    And request field "size" is "12"
    And request field "hash" is "bbb"
    When "qubeFileUpload" is called with token "ea67efd9-020a-490c-b76b-814c33925ee6"
    And gets a successful response
    And the response field "fileId" is "User already exists"

    
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
