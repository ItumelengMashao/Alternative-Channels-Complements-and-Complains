Feature: create user by API
  Background:
    * url 'https://gorest.co.in'
    * configure ssl = true
    * header Content-Type = 'application/json'
    * header Authorization = 'Bearer 3481461ed252bff1ee08aca5049e024a883d8a5b0a6ae50f90ec19204e369878'
  Scenario: create a user via api
    Given path '/public/v2/users'
    And request  {"id": 757,"name": "Matt","email": "hwq@stokyeus722.com","gender": "male","status": "active"}
    When method POST
    Then status 201
