Feature: Web Simulator
  As a web user
  I want to use the web simulator
  to have more information about a credit in which I am interested

  Scenario: Simulate a mortgage loan
    When Jenn simulate a mortgage loan worth 30000000
    Then she should see a video with the simulation detail