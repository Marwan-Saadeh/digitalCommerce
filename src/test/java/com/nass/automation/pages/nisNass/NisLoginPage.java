package com.nass.automation.pages.nisNass;

import com.nass.automation.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NisLoginPage extends PageBase {

    public NisLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input.SignInForm-email") private WebElement emailField;
    private WebElement getEmailField(){
        return emailField;
    }

    @FindBy(css = "input.SignInForm-password") private WebElement passwordField;
    private WebElement getPasswordField(){
        return passwordField;
    }

    @FindBy(css = "button.SignInForm-signInButton") private WebElement signInButton;
    private WebElement getSignInButton(){
        return signInButton;
    }

    @FindBy(css = "a.SignInForm-signUpButton") private WebElement signUpButton;
    private WebElement getSignUpButton(){
        return signUpButton;
    }

    @FindBy(css = "button.SignInForm-forgotPasswordLink") private WebElement forgotPasswordLink;
    private WebElement getForgotPasswordLink(){
        return forgotPasswordLink;
    }

    public NisHomePage login(String email, String password){
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getSignInButton().click();
        return new NisHomePage(driver);
    }
}
