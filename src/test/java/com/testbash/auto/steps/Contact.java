package com.testbash.auto.steps;

import org.testng.Assert;

import com.testbash.auto.pages.ContactPage;
import com.testbash.auto.setup.Setup;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Contact extends Setup{

	ContactPage cp = new ContactPage(driver);
	String verifyName;
	
	@Given("^Load home page$")
	public void load_home_page() throws Throwable {
		startNavigation();
		
	}

	@When("^Enter name \"([^\"]*)\"$")
	public void enter_name(String name) throws Throwable {
		cp.enterName(name);
		verifyName = name;
	}

	@And("^Enter email \"([^\"]*)\"$")
	public void enter_email(String email) throws Throwable {
		cp.enterEmail(email);
	}

	@And("^Enter phone \"([^\"]*)\"$")
	public void enter_phone(String phone) throws Throwable {
		cp.enterPhone(phone);
	}

	@And("^Enter subject \"([^\"]*)\"$")
	public void enter_subject(String subject) throws Throwable {
		cp.enterSubject(subject);
	}

	@And("^Enter message \"([^\"]*)\"$")
	public void enter_message(String message) throws Throwable {
		cp.enterMessage(message);
	}
	
	@And("^CLick Submit button$")
	public void click_Submit_button() throws Throwable {
		cp.ClickOnSubmit();
	}

	@Then("^we see successful message$")
	public void we_see_successful_message() throws Throwable {
		Thread.sleep(2000);
		log.info(cp.getSuccessfulMessage());
		Assert.assertTrue(cp.getSuccessfulMessage().contains(verifyName));
		Thread.sleep(5000);
	}
	
	
	@When("^fill out all the field$")
	public void fill_out_all_the_field() throws Throwable {
		eyes.checkWindow("before contact Window");
		cp.enterName("Pierre");
		cp.enterEmail("pirre@gmail.com");
		cp.enterPhone("123456789900777");
		cp.enterSubject("Hello there");
		cp.enterMessage("There is some discussion");
		cp.ClickOnSubmit();
	}

	@Then("^we compare screen$")
	public void we_compare_screen() throws Throwable {
		eyes.checkWindow("after contact Window");
	}
}
