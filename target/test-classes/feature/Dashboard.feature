#Author: hafiz.kabul@gmail.com
Feature: Dashboard
Scenario: Dashboard menue view for admin

    When user logged with valid admin credentials
    Then user see dashboard menue is displayed
    |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|
    