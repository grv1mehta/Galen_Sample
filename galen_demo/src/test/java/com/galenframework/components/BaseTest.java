package com.galenframework.components;

import com.galenframework.testng.GalenTestNgTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

public abstract class BaseTest extends GalenTestNgTestBase {

	private static final String ENV_URL = ReadData
			.readDataFromPropertyFile("baseUrl");
	String pagepath;
	static WebDriver driver;
	private static String browser = ReadData
			.readDataFromPropertyFile("browser");

	@Override
	public WebDriver createDriver(Object[] args) {

		browser = "chrome";

		if (browser == "chrome") {
			System.setProperty("webdriver.chrome.driver",
					"src/test/resources/drivers/chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browser == "firefox") {
			System.setProperty("webdriver.firefox.marionette",
					"src/test/resources/drivers/geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (browser == "ie") {
			System.setProperty("webdriver.ie.driver",
					"src/test/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out
					.println("***** WARNING ***** - BROWSER value provided is NULL or BLANK so initiating default (chrome) browser.");
			System.setProperty("webdriver.chrome.driver",
					"src/test/resources/drivers/chromedriver.exe");

			driver = new ChromeDriver();
		}

		if (args.length > 0) {
			if (args[0] != null && args[0] instanceof TestDevice) {
				TestDevice device = (TestDevice) args[0];
				if (device.getScreenSize() != null) {

					driver.manage().window().setSize(device.getScreenSize());
				}
			}
		}
		return driver;
	}

	/*
	 * public void maximize(Object[] args) { if (args.length > 0) { if (args[0]
	 * != null && args[0] instanceof TestDevice) { TestDevice device =
	 * (TestDevice)args[0]; if (device.getScreenSize() != null) {
	 * 
	 * driver.manage().window().setSize(device.getScreenSize()); } } } }
	 */

	public void load(String path) {

		switch (path) {
		case "home page":
			pagepath = "/";
			break;
		case "login":
			pagepath = ReadData.readDataFromPropertyFile("loginPath");
			break;
		}
		
		getDriver().get(ENV_URL + pagepath);
		getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
	}
	@DataProvider(name = "desktop")
	public Object[][] desktop() {
		return new Object[][] { { new TestDevice("desktop", new Dimension(1440,
				1024), asList("desktop")) } };
	}
	
	@DataProvider(name = "tablet")
	public Object[][] tablet() {
		return new Object[][] { { new TestDevice("tablet", new Dimension(800,
				1024), asList("tablet")) } };
	}

	@DataProvider(name = "mobile")
	public Object[][] mobile() {
		return new Object[][] { { new TestDevice("mobile", new Dimension(375,
				667), asList("mobile")) } };
	}

	@DataProvider(name = "allDevices")
	public Object[][] devices() {
		return new Object[][] {
				{ new TestDevice("mobile", new Dimension(450, 800),
						asList("mobile")) },
				{ new TestDevice("tablet", new Dimension(750, 800),
						asList("tablet")) },
				{ new TestDevice("desktop", new Dimension(1400, 825),
						asList("desktop")) } };
	}

	public static class TestDevice {
		private final String name;
		private final Dimension screenSize;
		private final List<String> tags;

		public TestDevice(String name, Dimension screenSize, List<String> tags) {
			this.name = name;
			this.screenSize = screenSize;
			this.tags = tags;
		}

		public String getName() {
			return name;
		}

		public Dimension getScreenSize() {
			return screenSize;
		}

		public List<String> getTags() {
			return tags;
		}

		@Override
		public String toString() {
			return String.format("%s %dx%d", name, screenSize.width,
					screenSize.height);
		}
	}
}
