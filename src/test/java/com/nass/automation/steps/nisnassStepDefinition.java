package com.nass.automation.steps;

import com.nass.automation.common.PageFactory;
import cucumber.api.java.en.*;

public class nisnassStepDefinition {

    @Given("^Navigate to NISNASS site$")
    public void navigate_to_NISNASS_site() throws Throwable {
        PageFactory.instance().nisHomePage().navigateToLoginPage();
    }

    @When("^Login with username \"(.*?)\" and password \"(.*?)\"$")
    public void login_with_username_and_password(String email, String password) throws Throwable {
        PageFactory.instance().nisLoginPage().login(email, password);
    }

    @When("^Navigate to Account page$")
    public void navigate_to_Account_page() throws Throwable {
        PageFactory.instance().nisHomePage().navigateToAccountPage();
    }

    @When("^Update the phone number to \"(.*?)\" with \"(.*?)\" country code$")
    public void update_the_phone_number_to_with_country_code(String phoneNumber, String countryCode) throws Throwable {
        PageFactory.instance().nisAccountPage().navigateToInformationPage().updatePhoneNumberField(countryCode, phoneNumber);
    }

    @Then("^Verify that the “Email-Address” field is un-editable$")
    public void verify_that_the_Email_Address_field_is_un_editable() throws Throwable {
        PageFactory.instance().nisAccountPage().navigateToInformationPage().verifyThatEmailNotEditable();
    }

    @Then("^Verify that the \"([^\"]*)\" email displays in email field$")
    public void verify_that_the_email_displays_in_email_field(String email) throws Throwable {
        PageFactory.instance().nisAccountPage().navigateToInformationPage().verifyEmailFieldValue("nnwrs2008@yahoo.com");
    }

    @Then("^Verify that the phone number updated successfully$")
    public void verify_that_the_phone_number_updated_successfully() throws Throwable {
        
    }

}
