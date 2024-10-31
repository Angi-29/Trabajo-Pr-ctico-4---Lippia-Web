@project
Feature: Time Tracker

  Background:
    Given The client is logged in on the page
    And the user clicks Time Tracker

  @addTimeTracker  @Do @Smoke
  Scenario Outline: Successful time registration manual
    Given the user clicks add manual
    When the user clicks Time Tracker
    And the user click on the calendar
    And The user enters the date "<Date>"
    And The user sets the start time to "<StartTime>"
    And The user sets the end time to "<EndTime>"
    And the user add description "<Description>"
    And the user clicks the Add button
    Then  the user sees the recorded time tracker
    Examples:
      | Date       | StartTime | EndTime | Description |
      | 2024-10-30 | 09:00     | 17:00   | automation  |

