@Login
Feature: As a potential client I need to login

  Background:
    Given The client is on landing page
    And The client click on 'Log In'

  @LoginSuccesfull @Do
  Scenario: The client does a succesfull login
    When The client click on 'Log in manually'
    And The client set the email 'cuentaparapruebas933@gmail.com'
    And The client set the password 'Contrasena123'
    And The client click on button 'Login'
    Then The client is on the time tracker page

  @LoginFailed @Do
  Scenario:The client does a failed login
    When The client click on 'Log in manually'
    And The client set the email 'cuentaparapruebas933@gmail.com'
    And The client set the password 'Contrasena'
    And The client click on button 'Login'
    Then The client should see an error message 'Invalid password'

  @LoginFail @Do  @Negative
  Scenario: The client does a failed login due to invalid email format
    When The client click on 'Log in manually'
    And The client set the email 'cuentaparapruebas933gmail.com'
    And The client set the password 'Contrasena123'
    And The client click on button 'Login'
    Then The client should see an error message 'Email format is not valid'

  @Logout @Do
  Scenario: The client logout successfully
    Given The client is successfully logged in with email 'cuentaparapruebas933@gmail.com', password 'Contrasena123', and button "Login"
    When The client click the profile menu button
    And The client click on 'Sign out'
    Then The client should then be redirected to the login page "https://app.clockify.me/en/login"
