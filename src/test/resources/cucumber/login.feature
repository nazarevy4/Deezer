Feature: Login functionality

  Scenario: Verify that user is logged in when valid credentials are passed
    Given deezer login page is opened
    When user enters login "nazar.stukalo@yahoo.com" and password "password!@#"
    Then user is logged in

  Scenario: Verify that user is logged in when valid credentials are passed
    Given deezer login page is opened
    When user enters login "nazar.stukalo@yahoo.com" and password "testpassword"
    Then user is not logged in
