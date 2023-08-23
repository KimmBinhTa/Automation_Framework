package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Common.BasePageFactory;

public class HomePage_PageFactory extends BasePageFactory{
	
	WebDriver driver;
	
	public HomePage_PageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this );
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	public void clickToRegisterLink() {
		clickToElement(registerLink);
		
	}

}
