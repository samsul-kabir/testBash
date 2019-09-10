package com.testbash.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testbash.auto.basepage.BasePage;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "name")
	private WebElement nameLoc;

	@FindBy(id = "email")
	private WebElement emailLoc;

	@FindBy(id = "phone")
	private WebElement phoneLoc;

	@FindBy(id = "subject")
	private WebElement subjectLoc;

	@FindBy(id = "description")
	private WebElement descriptionLoc;

	@FindBy(id = "submitContact")
	private WebElement submitButtonLoc;
	
	@FindBy(css = ".row.contact h2")
	private WebElement successfullMessage;

	public void enterName(String name) {
		enterIntoTextField(nameLoc, name);
	}

	public void enterEmail(String email) {
		enterIntoTextField(emailLoc, email);
	}

	public void enterPhone(String phone) {
		enterIntoTextField(phoneLoc, phone);
	}

	public void enterSubject(String subject) {
		enterIntoTextField(subjectLoc, subject);
	}

	public void enterMessage(String message) {
		enterIntoTextField(descriptionLoc, message);
	}

	public void ClickOnSubmit() {
		clickOnButton(submitButtonLoc);
	}
	
	public String getSuccessfulMessage() {
		return returnText(successfullMessage);
	}
}
