Feature: check returned data by API
  Background:
    * header Accept = 'application/json'
    * configure ssl = true
    * def expectedOutput = read('expectedResults.json')

  Scenario: get list of all data and compare of user 1
    Given url 'https://reqres.in/api/users/2'
    When method get
    Then status 200
    Then print response
    And match response == expectedOutput[0]
    And match response.data.last_name != null
    And match response.data.last_name == 'Weaver'

  Scenario: get list of all data and compare of user 2
    Given url 'https://reqres.in/api/users/3'
    When method get
    Then status 200
    Then print response
    And match response == expectedOutput[1]
    And match response.data.last_name != null
    And match response.data.last_name == 'Wong'