package com.nass.automation.common;

import com.nass.automation.pages.nisNass.NisAccountPage;
import com.nass.automation.pages.nisNass.NisHomePage;
import com.nass.automation.pages.nisNass.NisLoginPage;

public class PageFactory extends PageFactoryAbstract {

	private static PageFactory _pageFactory;

	public PageFactory() {
		super();
	}

	public static PageFactory instance() {
		if (_pageFactory == null) {
			_pageFactory = new PageFactory();
		}
		return _pageFactory;
	}

	// pages object
	private static NisLoginPage _nisLoginPage;
	private static NisHomePage _nisHomePage;
	private static NisAccountPage _nisAccountPage;

	public NisLoginPage nisLoginPage() {
		if (_nisLoginPage == null) {
			_nisLoginPage = new NisLoginPage(getWebDriver());
		}
		return _nisLoginPage;
//		return new NisLoginPage(getWebDriver());
	}

	public NisHomePage nisHomePage() {
		if (_nisHomePage == null) {
			_nisHomePage = new NisHomePage(getWebDriver());
		}
		return _nisHomePage;
//		return new NisHomePage(getWebDriver());
	}

	public NisAccountPage nisAccountPage() {
		if (_nisAccountPage == null) {
			_nisAccountPage = new NisAccountPage(getWebDriver());
		}
		return _nisAccountPage;
//		return new NisAccountPage(getWebDriver());
	}

}
