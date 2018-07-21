package com.nass.automation.common;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

	static WebDriver driver;

	/**
	 * 
	 * @return FireFox WebDriver
	 */
	public static WebDriver createInstance() {
		return createInstance(null);
	}

	/**
	 *
	 * @param browserName
	 *            Firefox ,Chrome ,IE ,Edge ,Safari ,HtmlUnit or HtmlUnitJs
	 *
	 * @return WebDriver
	 */
	public static WebDriver createInstance(String browserName) {

		browserName = (browserName != null) ? browserName : "FIREFOX";

		switch (Browsers.valueOf(browserName.toUpperCase())) {
			case FIREFOX:
				FirefoxDriverManager.getInstance().setup();
				driver = new FirefoxDriver();
				break;
			case IE:
				InternetExplorerDriverManager.getInstance().setup();
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				driver = new InternetExplorerDriver(caps);
				break;
			case CHROME:
				ChromeDriverManager.getInstance().setup();
				driver = new ChromeDriver();
				break;
			case EDGE:
				EdgeDriverManager.getInstance().setup();
				driver = new EdgeDriver();
				break;
			case HTMLUNIT:
				driver = new HtmlUnitDriver();
				break;
			case HTMLUNITJS:
				driver = new HtmlUnitDriver(true);
				break;
			case SAFARI:
				driver = new SafariDriver();
				break;
			default:
				ChromeDriverManager.getInstance().setup();
				driver = new ChromeDriver();
				break;
		}
		// maximize browser's window on start
		driver.manage().window().maximize();
//		driver.manage().window().fullscreen();
//		driver.manage().window().setPosition(new Point(0,0));
//		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}


	private enum Browsers {
		FIREFOX, CHROME, IE, EDGE, SAFARI, HTMLUNIT, HTMLUNITJS;
	}
}