package com.galenframework.tests;

import static java.util.Arrays.asList;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.galenframework.components.BaseTest;

public class SampleTest extends BaseTest {

	@Test(dataProvider = "desktop")
	public void sampleTestOnDesktop(TestDevice device) throws IOException {
		// getDriver().manage().window().maximize();
		load("home page");
		checkLayout("/specs/demoPage.spec", asList("desktop"));
	}
	
	@Test(dataProvider = "tablet")
	public void sampleTestOnTablet(TestDevice device) throws IOException {
		load("home page");
		checkLayout("/specs/demoPage.spec", asList("tablet"));
	}

	@Test(dataProvider = "mobile")
	public void sampleTestOnMobile(TestDevice device) throws IOException {
		load("home page");
		checkLayout("/specs/demoPage.spec", asList("mobile"));
	}
}
