package com.nass.automation.runner;

import java.io.IOException;

import com.nass.automation.common.PageFactory;
import com.nass.automation.common.util.StateHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void hookBeforeScenario() {
        System.out.println("custom Before scenario hook");
        PageFactory.instance().deleteAllDriverCookies();
    }

    @After
    public void hookAfterScenario(Scenario scenario) {
    	System.out.println("custom After scenario hook");
    	try {
			StateHelper.clearStepState();
		} catch (IOException e) {
			System.err.println("ERROR");
		}

    	PageFactory.instance().deleteAllDriverCookies();
        if (scenario.isFailed()) {
        	final byte[] screenshot  = ((TakesScreenshot) PageFactory.instance().getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);        
            scenario.embed(screenshot , "image/png"); //stick it in the report
        }

    }

}