package PageObject;

public class RegisterPageUI {
	
	public static final String REGISTER_BTN = "//button[@id='register-button']";
	public static final String FIRST_NAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	
	public static final String FIRST_NAME = "//input[@id='FirstName']";
	public static final String LAST_NAME = "//input[@id='LastName']";
	public static final String EMAIL = "//input[@id='Email']";
	public static final String PASSWORD = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD = "//input[@id='ConfirmPassword']";
	public static final String ERROR_MESSAGE_EXITS_EMAIL = "//div[contains(@class,'summary-errors')]//li";
}
