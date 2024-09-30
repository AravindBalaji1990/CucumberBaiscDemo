Feature:  Test the Api Demo App
  test the app open
  check for the button text is available

  Background:
    Given User open the api demos app

    @SIT
  Scenario: validate the Text button
    When User clicks on the text button
    And User validates the text screen
    Then User closes the app

    @SANITY
  Scenario: validate the Linkify button
    When User clicks on the text button
    And User validates the text screen with Linkify
    Then User closes the app

    @SMOKE
  Scenario: validate the LogTextBox button
    When User clicks on the text button
    And User validates the text screen with button "LogTextBox"
    Then User closes the app

  @REGRESSIONTEST
  Scenario: validate the Marquee and Unicode button
    When User clicks on the text button
    And User validates the text screen with list of options
      | options |
      | Marquee |
      | Unicode |
    Then User closes the app

  @REGRESSIONTEST @SMOKE
  Scenario Outline: validate the Marquee and Unicode button with table format - <options>
    When User clicks on the text button
    And User validates the text screen with list of options from the <options>
    Then User closes the app

    Examples:
      | options |
      | Marquee |
      | Unicode |
