@project
Feature: As a client I want to create a new project

  Background:
    Given The client is logged in on the page
  @CreateNewProject  @Do
  Scenario: Successful creation of a project with valid data
    When the user clicks Create new project
    And Enter a valid project name
    And clicks the Create button
    Then The project should be created successfully



