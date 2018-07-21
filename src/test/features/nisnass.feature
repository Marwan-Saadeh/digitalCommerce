@nisnass
Feature: Automation test for nisnass.com site

  Scenario: Verify that the Email field is not editable
    Given Navigate to NISNASS site
    When Login with username "nnwrs2008@yahoo.com" and password "Admin@123"
    And Navigate to Account page
    Then Verify that the “Email-Address” field is un-editable

  Scenario: Verify the Email field value
    Given Navigate to NISNASS site
    When Login with username "nnwrs2008@yahoo.com" and password "Admin@123"
    And Navigate to Account page
    Then Verify that the "nnwrs2008@yahoo.com" email displays in email field

  Scenario: Verify Update the phone number
    Given Navigate to NISNASS site
    When Login with username "nnwrs2008@yahoo.com" and password "Admin@123"
    And Navigate to Account page
    And Update the phone number to "67324238" with "971" country code
    Then Verify that the phone number updated successfully
