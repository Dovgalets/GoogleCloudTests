Feature: Google Calculator Feature

  @1
  Scenario: Checking the Google Calculator price coincide with the price from letter
    Given Open Google Cloud site
    When Select Pricing Calculator for Compute Engine
    And Input required configuration
    And Receive Price from the site
    And Receive Price from letter
    Then Price from Site and Price from Letter should Coincide

