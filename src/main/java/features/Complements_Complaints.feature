Feature: check returned API
  Background:
    * header Accept = 'application/json'
    * configure ssl = true
    * def data = read('Complaints_Complements_Data.json')
    * def javaClass = Java.type('features.JavaFunctions')
    * def randomNumber = new javaClass().getRandomNumber();
    
  Scenario: Creating a Complaint/Complements

    Given url 'https://vmsatmapi.vms-atmcc-sit.rbb-banking.sdc-nonprod.caas.absa.co.za/atmcomplaints'
    And request data[randomNumber]
    When method POST
    And print data[randomNumber]
    Then status 200

  Scenario: Get all list of complains and complements
    Given url 'https://vmsatmapi.vms-atmcc-sit.rbb-banking.sdc-nonprod.caas.absa.co.za/atmcomplaints'
    When method get
    Then status 200
    Then print response

  Scenario: Validate if the persisted data exist in the API
    Given url 'https://vmsatmapi.vms-atmcc-sit.rbb-banking.sdc-nonprod.caas.absa.co.za/atmcomplaints'
    And request data[randomNumber]
    When method POST
    And print data[randomNumber]
    Then status 200
    When method get
    Then status 200
    Then print response[randomNumber]
