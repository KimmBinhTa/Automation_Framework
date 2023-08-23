package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Common.BasePageFactory;

public class RegisterPage_PageFactory extends BasePageFactory {
	
	WebDriver driver;
	public RegisterPage_PageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this );
	}

	@FindBy(how = How.XPATH, using = "//button[@id='register-button']")
	private WebElement registerBtn;
	
	@FindBy(how = How.XPATH, using = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	
	public void clickToRegisterBtn() {
		clickToElement(registerBtn);
		
	}

	public String getErrorMessageAtFirstName() {
		return getTextElement(firstNameErrorMessage);
	}

	public String getErrorMessageAtLastName() {
		return getTextElement(lastNameErrorMessage);
	}

	public String getErrorMessageAtEmail() {
		return getTextElement(emailErrorMessage);
	}

	public String getErrorMessageAtPassword() {
		return getTextElement(passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPassword() {
		return getTextElement(confirmPasswordErrorMessage);
	}

}
