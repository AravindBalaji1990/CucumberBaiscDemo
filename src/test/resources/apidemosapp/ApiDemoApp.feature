Feature:  Test the Api Demo App
  test the app open
  check for the button text is available

#  Background:
#    Given User open the api demos app

    @SIT
  Scenario: validate the Text button
    When User clicks on the text button
    And User validates the text screen

    @SANITY
  Scenario: validate the Linkify button
    When User clicks on the text button
    And User validates the text screen with Linkify

    @SMOKE
  Scenario: validate the LogTextBox button
    When User clicks on the text button
    And User validates the text screen with button "LogTextBox"

  @REGRESSIONTEST
  Scenario: validate the Marquee and Unicode button
    When User clicks on the text button
    And User validates the text screen with list of options
      | options |
      | Marquee |
      | Unicode |

  @REGRESSIONTEST @SMOKE
  Scenario Outline: validate the Marquee and Unicode button with table format - <options>
    When User clicks on the text button
    And User validates the text screen with list of options from the <options>

    Examples:
      | options |
      | Marquee |
      | Unicode |
