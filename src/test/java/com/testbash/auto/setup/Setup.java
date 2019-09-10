package com.testbash.auto.setup;

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

import cucumber.api.testng.AbstractTestNGCucumberTests;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Setup extends AbstractTestNGCucumberTests {
	protected static WebDriver driver;


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
		driver = createWebDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		
		
		
		if (!getBrowser().equals("headless")) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension screenResolution = new Dimension((int) toolkit.getScreenSize().getWidth(),
					(int) toolkit.getScreenSize().getHeight());
			driver.manage().window().setSize(screenResolution);
		}
	}

	@AfterSuite
	public void stopDriver() throws IOException {
		driver.manage().deleteAllCookies();
		driver.quit();	
	}

	public void startNavigation() throws InterruptedException {	
		driver.get("https://team1.automationintesting.online/#/");
		Cookie ck = new Cookie("welcome", "true");
		driver.manage().addCookie(ck);
		driver.navigate().refresh();
		
	}
}
