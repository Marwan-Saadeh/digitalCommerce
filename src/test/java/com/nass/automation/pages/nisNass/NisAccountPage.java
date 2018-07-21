package com.nass.automation.pages.nisNass;

import com.nass.automation.pages.PageBase;
import com.nass.automation.runner.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NisAccountPage extends PageBase {

    public NisAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "MyAccountPage-link")
    private List<WebElement> accountPageValue;
    private WebElement getEditYourDetailsLink() {
        return accountPageValue.get(0);
    }
    private WebElement getEditAddressLink() {
        return accountPageValue.get(1);
    }
    private WebElement getEditPaymentDetailsLink() {
        return accountPageValue.get(2);
    }
    private WebElement getEditCommunicationPreferencesLink() {
        return accountPageValue.get(3);
    }

    @FindBy(className = "Profile-email") private WebElement emailField;
    private WebElement getEmailField(){
        return emailField;
    }

    @FindBy(className = "Profile-phoneNumber") private WebElement phoneNumberField;
    private WebElement getPhoneNumberField(){
        return phoneNumberField;
    }

    @FindBy(css = "div.Select-input > input") private WebElement countryCode;
    private WebElement getCountryCode(){
        return countryCode;
    }

    @FindBy(className = "Profile-updateDetailsButton") private WebElement updateDetailsButton;
    private WebElement getUpdateDetailsButton(){
        return updateDetailsButton;
    }

    public NisAccountPage navigateToInformationPage() {
        getEditYourDetailsLink().click();
        return new NisAccountPage(driver);
    }

    public NisAccountPage verifyThatEmailNotEditable(){
        Assert.softAssert.assertFalse(getEmailField().isEnabled());
        return new NisAccountPage(driver);
    }

    public NisAccountPage verifyEmailFieldValue(String email){
        Assert.softAssert.assertTrue(getEmailField().getAttribute("value").contains(email));
        return new NisAccountPage(driver);
    }

    public NisAccountPage updatePhoneNumberField(String countryCode, String phoneNumber){
        getCountryCode().sendKeys(countryCode);
        getCountryCode().sendKeys(Keys.ENTER);
        getPhoneNumberField().clear();
        getPhoneNumberField().sendKeys(phoneNumber);
        getUpdateDetailsButton().click();
        return new NisAccountPage(driver);
    }

}
