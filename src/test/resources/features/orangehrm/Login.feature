Feature: User check Login feature

  @Smoke
  Scenario Outline:User check Successful Login
    Given user open orange HRM application
    When User enter "<username>" and "<password>"
    And User Click on sign in button
    Then User verify login

    Examples:
      | username | password |
      | Admin    | admin123 |