Feature: Post Request

  Scenario Outline: Post Request to make a Booking
    Given Get Payload from "<url>" and Make a call
    Then Verify response message "<msg>"
    Examples:
      | url   | msg |
      | /auth | 200 |

  Scenario Outline: Post Request to make a Booking
    Given Get Payload from "<url>" and Make a call
    Then Verify response message "<msg>"
    Examples:
      | url   | msg |
      | /auth | 200 |
