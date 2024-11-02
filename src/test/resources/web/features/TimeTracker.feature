@project
Feature: Time Tracker

  Background:
    Given The client is logged in on the page
    And the user clicks Time Tracker

  @addTimeTracker @Do
  Scenario Outline: Successful time registration manual
    Given the user clicks add manual
    When the user clicks Time Tracker
    #And the user click on the calendar
    And The user enters the date "<Date>"
    And The user sets the start time to "<StartTime>"
    And The user sets the end time to "<EndTime>"
    And the user add description "<Description>"
    And the user selects the "<Project>"
    And the user clicks the Add button
    Then  the user sees the recorded time tracker
    Examples:
      | Date       | StartTime | EndTime | Description | Project  |
      | 27/10/2024 | 09:00     | 17:00   | automation  | AngiTest |
      #| 28/10/2024 | 09:00     | 17:00   | automation  | AngiTest |


  @cancelTimerEntry @clockify @Do
  Scenario: Start a time entry and then cancel it
    When the user click add timer
    And the user add a description "Automation"
    And the user click on the start button
    And the user opens the Kebab menu and selects "Discard"
    And the user click "Discard" to confirm cancellation
    Then the user not view time tracker "Today"


  @Smoke
  Scenario Outline: The user Modify Time Traker
    Given the user selects the time tracker entry for "<dateModify>" to modify
    When the user enters new data: "<Description>","<Project>","<Time_START>","<Time_END>","<newDate>"
    And the user click save modify
    Then the user sees the modified data: "<Description>","<Project>","<Time_START>","<Time_END>","<Date>"
    Examples:
      | dateModify | Description      | Project | Time_START | Time_END | newDate       |
      | 2023-10-26 | Time_Traker_Edit | adios   | 08:00      | 10:00    | 20/10/2024 |



