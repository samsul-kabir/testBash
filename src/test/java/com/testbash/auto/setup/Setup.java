package com.testbash.auto.setup;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Setup extends AbstractTestNGCucumberTests {
	protected static WebDriver driver;
	protected static EyesRunner runner;
	protected static Eyes eyes;
	private static BatchInfo batch;

	public static String getBrowser() {
		return System.getProperty("browser");
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		return chromeOptions;
	}

	public static WebDriver createWebDriver() {
		switch (getBrowser()) {
		case "firefox":
			return new FirefoxDriver();
		case "chrome":
			return new ChromeDriver();
		case "headless":
			return new ChromeDriver(chromeOption());
		default:
			throw new RuntimeException("Unsupported webdriver: " + getBrowser());
		}
	}

	@BeforeSuite
	public void startDriver() {
		// Must be before ALL tests (at Class-level)
		batch = new BatchInfo("Demo batch");

		// Initialize the Runner for your test.
		runner = new ClassicRunner();

		// Initialize the eyes SDK
		eyes = new Eyes(runner);

		// Set your personal Applitols API Key from your environment variables.
		eyes.setApiKey("J7R8LfLw317a95UqYFRuLfYphTmfIv97399LNvelA6VHc110");

		// set batch name
		eyes.setBatch(batch);
		
		driver = createWebDriver();
	}

	@AfterSuite
	public void stopDriver() throws IOException {
		eyes.closeAsync();
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	public void startNavigation() throws InterruptedException {
		eyes.open(driver, "Demo App", "Smoke Test");

		driver.get("https://team1.automationintesting.online/#/");
		Cookie ck = new Cookie("welcome", "true");
		driver.manage().addCookie(ck);
		driver.navigate().refresh();
	}
}
