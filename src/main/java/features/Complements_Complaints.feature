Feature: check returned temp by API
  Background:
    * header Accept = 'application/json'
    * configure ssl = true
  Scenario: Get all list of complains and complements
    Given url 'https://vmsatmapi.vms-atmcc-sit.rbb-banking.sdc-nonprod.caas.absa.co.za/atmcomplaints'
    When method get
    Then status 200
    Then print response
    And match response == response

  Scenario: Creating a Complaint/Complements
    Given url 'https://vmsatmapi.vms-atmcc-sit.rbb-banking.sdc-nonprod.caas.absa.co.za/atmcomplaints'
    And request  {"ComplaintDate":"2022-04-18T06:34:18.917","CustomerName":"Customer Name 3","CustomerSurname":"Customer Surname 3","CustomerCellphone":"27836679174","CustomerEmail":"customer2@example.com","CtmNumber":"S08132","AtmLocation":"HILCREST BOULEVARD 1, 228 Lynnwood Road, Pretoria","isComplaint":true,"Reason":"Required denominations not available","Comments":"Required denominations not available"}
    When method POST
    Then status 200

