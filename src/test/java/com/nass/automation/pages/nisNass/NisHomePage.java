package com.nass.automation.pages.nisNass;

import com.nass.automation.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NisHomePage extends PageBase {

    public NisHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "icon-account") private WebElement accountButton;
    private WebElement getAccountButton(){
        return accountButton;
    }

    public NisLoginPage navigateToLoginPage(){
        driver.navigate().to("https://www.nisnass.ae/");
        getAccountButton().click();
        return new NisLoginPage(driver);
    }

    public NisAccountPage navigateToAccountPage() throws Throwable {
        Thread.sleep(5000);
        getAccountButton().click();
        return new NisAccountPage(driver);
    }

}
