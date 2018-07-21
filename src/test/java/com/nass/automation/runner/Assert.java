package com.nass.automation.runner;

import com.nass.automation.common.PageFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Maps;

import java.io.IOException;
import java.util.Map;

public class Assert extends Assertion {

	public static SoftAssert softAssert = new SoftAssert();

	@Before
	public void beforeAssert() throws IOException, InterruptedException {
		softAssert = new SoftAssert();
		System.out.println("beforeScenario is called");
	}

	@Override
	public void onAssertFailure(IAssert<?> var1, AssertionError var2) {
		this.onAssertFailure(var1);
		final byte[] screenshot = ((TakesScreenshot) PageFactory.instance().getWebDriver())
				.getScreenshotAs(OutputType.BYTES);
		Reporter.getCurrentTestResult();
	}

	@After
	public void afterAssert() throws IOException {
		softAssert.assertAll();
		System.out.println("afterScenario is called");
	}

}
