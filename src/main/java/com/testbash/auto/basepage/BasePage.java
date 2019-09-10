package com.testbash.auto.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnButton(WebElement button) {
		button.click();
	}

	public void enterIntoTextField(WebElement textField, String text) {
		textField.sendKeys(text);
	}

	public String returnText(WebElement textField) {
		return textField.getText();
	}

	public String returnClassAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
}
