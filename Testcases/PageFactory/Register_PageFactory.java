package PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageFactory.HomePage_PageFactory;
import PageFactory.RegisterPage_PageFactory;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.RegisterPageObject;

public class Register_PageFactory {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePage_PageFactory homePage;
	RegisterPage_PageFactory registerPage;
	
	
	String email = "john123@gmail.com";
	String password = "123456";
	String passwordError = "567890";
	String emailError = "auto00@gmail.com";
	
	@BeforeClass
	public void beforeClassABC() {
		// Khai báo chromedriver
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		// Khởi tạo driver để điều khiển browser
		driver = new ChromeDriver();
		// Set timeout để tìm element
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		homePage = new HomePage_PageFactory(driver);
		registerPage = new RegisterPage_PageFactory(driver);
		
		
		driver.get("https://demo.nopcommerce.com/");

	}
	
	@Test
	public void TC_01() {
		homePage.clickToRegisterLink();

		registerPage.clickToRegisterBtn();

		Assert.assertEquals(registerPage.getErrorMessageAtFirstName(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastName(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmail(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPassword(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassword(), "Password is required.");

	}
	
	@AfterClass
	public void afterClas() {
		driver.quit();
	}
}
