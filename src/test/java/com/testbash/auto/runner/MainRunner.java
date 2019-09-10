package com.testbash.auto.runner;

import org.junit.runner.RunWith;

import com.testbash.auto.setup.Setup;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions (
		features = {"src/test/resource/features/contact.feature"},
		glue = {"com.testbash.auto.steps"},
		plugin = {"pretty","html:target/cucumber",
				"json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"})


public class MainRunner extends Setup{

}
