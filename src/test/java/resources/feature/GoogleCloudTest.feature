Feature: Google Calculator Feature

  @1
  Scenario: Verify that Google Calculator price coincide with the same from letter
    Given I open Google Cloud site
    When I select Pricing and Calculators
    And I input configuration
    Then Price from Site and Price from Letter should Coincide

