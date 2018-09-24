Feature: test

Scenario: a few cukes
  Given deezer login page is opened
  When valid creds are passed
  Then user is logged in