@workspace
Feature: As a client I want to create a Workspace Management

  Background:
    Given The clients is on landing page
    And The client click on 'Log In'
    And The client is logged in with email 'cuentaparapruebas933@gmail.com', password 'Contrasena123' and click on button 'Login'

  @createWorkspace @Do @Smoke
  Scenario: Successful creation of workspace with a valid name
    When The client clicks on the Meatballs menu and selects 'Manage Workspaces'
    And the client clicks the 'Create new workspace' button
    And the client enters a valid name 'CrowdarAcademyTests-3'
    And the client clicks on the 'create' button
    Then the new workspace should be created correctly
