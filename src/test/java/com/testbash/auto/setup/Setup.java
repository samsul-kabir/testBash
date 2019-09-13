package com.testbash.auto.setup;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	private static String sauceUserName = System.getenv("SAUCE_USERNAME");
	private static String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
	private static String sauceURL = "https://ondemand.saucelabs.com/wd/hub";
	private static MutableCapabilities capabilities;

	public static String getBrowser() {
		return System.getProperty("browser");
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		return chromeOptions;
	}

	public static WebDriver createWebDriver() throws MalformedURLException {
		switch (getBrowser()) {
		case "firefox":
			return new FirefoxDriver();
		case "chrome":
			return new ChromeDriver();
		case "headless":
			return new ChromeDriver(chromeOption());
		case "sauce":
			shouldOpenChrome();
			return new RemoteWebDriver(new URL(sauceURL), capabilities);
		default:
			throw new RuntimeException("Unsupported webdriver: " + getBrowser());
		}
	}
	
	public static void shouldOpenChrome() throws MalformedURLException {   
        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("username", sauceUserName);
        sauceOpts.setCapability("accessKey", sauceAccessKey);
        /** In order to use w3c you must set the seleniumVersion **/
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("name", "4-best-practices");
 
        
        List<String> tags = Arrays.asList("sauceDemo", "demoTest", "module4", "javaTest");
        sauceOpts.setCapability("tags", tags);
        
        sauceOpts.setCapability("maxDuration", 3600);
        
        sauceOpts.setCapability("commandTimeout", 600);
        
        sauceOpts.setCapability("idleTimeout", 1000);
  
        sauceOpts.setCapability("build", "Onboarding Sample App - Java-Junit5");
 
        /** Required to set w3c protoccol **/
        ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.setExperimentalOption("w3c", true);
 
        /** Set a second MutableCapabilities object to pass Sauce Options and Chrome Options **/
        capabilities = new MutableCapabilities();
        capabilities.setCapability("sauce:options", sauceOpts);
        capabilities.setCapability("goog:chromeOptions", chromeOpts);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platformVersion", "Windows 10");
        capabilities.setCapability("browserVersion", "latest");     
    }

	@BeforeSuite
	public void startDriver() throws MalformedURLException {
		
//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//		caps.setCapability("platform", "macOS 10.14");
//		caps.setCapability("version", "77.0");
//		
//		// Must be before ALL tests (at Class-level)
//		batch = new BatchInfo("Demo batch");
//
//		// Initialize the Runner for your test.
//		runner = new ClassicRunner();
//
//		// Initialize the eyes SDK
//		eyes = new Eyes(runner);
//
//		// Set your personal Applitols API Key from your environment variables.
//		eyes.setApiKey("J7R8LfLw317a95UqYFRuLfYphTmfIv97399LNvelA6VHc110");
//
//		// set batch name
//		eyes.setBatch(batch);
		
		driver = createWebDriver();
	}

	@AfterSuite
	public void stopDriver() throws IOException {
		//eyes.closeAsync();
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	public void startNavigation() throws InterruptedException {
		//eyes.open(driver, "Demo App", "Smoke Test");

		driver.navigate().to("https://www.saucedemo.com");
//		Cookie ck = new Cookie("welcome", "true");
//		driver.manage().addCookie(ck);
//		driver.navigate().refresh();
	}
}
