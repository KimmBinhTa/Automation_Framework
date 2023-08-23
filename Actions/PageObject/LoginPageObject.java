package PageObject;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageObject.HomePageUI;
import PageObject.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputEmail(String email) {
		senKeysElement(driver, LoginPageUI.EMAIL_TXT, email);
		
	}
	public void inputPassword(String password) {
		senKeysElement(driver, LoginPageUI.PASSWORD_TXT, password);
		
	}
	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}
	public void clickToLoginBtn() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
	}
	
	public String getErrorMessageAtEmailTxb() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	public String getErrorMessageAtNotRegisterEmailTxb() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_NOT_REGISTER_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_NOT_REGISTER_ERROR_MESSAGE);
	}
	
}
