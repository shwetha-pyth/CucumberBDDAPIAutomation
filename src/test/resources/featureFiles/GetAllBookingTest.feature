Feature: Get All Booking and Verify

  Scenario Outline: Get All Booking and Verify Status Code
    Given Get Call to "<url>"
    When I make a Post request
    Then Response Code "<responseCode>" is verified
    Examples:
      | url      | responseCode |
      | /booking | 200          |
