package PageObject;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageObject.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;
	String firstName = "Alex";
	String lastName = "Doll";
	String email = "alex1@gmail.com";
	String password = "12345678";
	String confirmPassword = "12345678";
	
	public RegisterPageObject(WebDriver mappingDriver) {
		this.driver = mappingDriver;
	}
	
	public void clickToRegisterBtn() {
		clickToElement(driver, RegisterPageUI.REGISTER_BTN);
	}
	public String getErrMessageAtFirstNametbx() {
		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	public String  getErrMessageAtLastNametbx() {
		return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	public String getErrMessageAtEmailtbx() {
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	public String getErrMessageAtPasswordtbx() {
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	public String getErrMessageAtConfirmPasswordtbx() {
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	public String getErrMessageExitsEmail() {
		return getTextElement(driver, RegisterPageUI.ERROR_MESSAGE_EXITS_EMAIL);
	}
	
	
	public void inputFirtName() {
		senKeysElement(driver, RegisterPageUI.FIRST_NAME, firstName);
	}
    public void inputLastName() {
    	senKeysElement(driver, RegisterPageUI.LAST_NAME, lastName);
	}
    public void inputWrongEmail() {
    	senKeysElement(driver, RegisterPageUI.EMAIL, "aaa123");
	}
    public void inputEmail() {
    	senKeysElement(driver, RegisterPageUI.EMAIL, email);
	}
    public void inputPassword() {
    	senKeysElement(driver, RegisterPageUI.PASSWORD, password);
	}
    public void inputWrongPassword() {
    	senKeysElement(driver, RegisterPageUI.PASSWORD, "1234");
	}
    
    public void inputConfirmPassword() {
    	senKeysElement(driver, RegisterPageUI.CONFIRM_PASSWORD, confirmPassword);
	}
    public void inputWrongConfirmPassword() {
    	senKeysElement(driver, RegisterPageUI.CONFIRM_PASSWORD, "1235698");
	}
}
