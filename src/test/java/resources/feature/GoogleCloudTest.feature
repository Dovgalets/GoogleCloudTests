Feature: Google Cloud Calculator Feature

  @sanity @smoke
  Scenario Outline: Checking the Google Calculator price coincide with the price from letter
    Given Open Google Cloud site
    When Select Pricing Calculator for Compute Engine
    And Input required configuration parameters "<Number of instances>"
    And Input optional configuration parameters from Excel file "<Name of file>" sheet "<Sheet Name>" raw "<Raw>"
    And Receive Price from the site
    And Receive Price from letter
    Then Price from Site and Price from Letter should Coincide
    Examples:
      | Number of instances | Name of file            | Sheet Name | Raw |
      | 4                   | OptionalParameters.xlsx | Sheet1     |2    |