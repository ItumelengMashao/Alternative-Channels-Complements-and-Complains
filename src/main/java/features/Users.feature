Feature: check returned Users by API
  Background:
    * url 'https://gorest.co.in'
    * configure connectTimeout = 6000000
    * configure readTimeout = 6000000
    * configure ssl = true
  Scenario: get list of all Users
    Given path '/public/v2/users'
    When method get
    Then status 200
    Then print response

