package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.RegisterPageObject;

public class LoginPOM {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;
	
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
		
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);
		
		driver.get("https://demo.nopcommerce.com/");

	}
	//@Test
	public void TC_01_Login_with_empty_data() {
		 loginPage.clickToLoginLink();
		 loginPage.clickToLoginBtn();
		 
		
		 Assert.assertEquals(loginPage.getErrorMessageAtEmailTxb(), "Please enter your email");
		 
	}
	//@Test
	public void TC_02_Login_with_invalid_email() {
		 loginPage.clickToLoginLink();
		 
		 loginPage.inputEmail(emailError);
		 loginPage.inputPassword(password);
		 
		 loginPage.clickToLoginBtn();
		 
		 
		 Assert.assertEquals(loginPage.getErrorMessageAtEmailTxb(), "Wrong email");
	}
	//@Test
	public void TC_03_Login_with_not_register_email() {
		 loginPage.clickToLoginLink();
		 loginPage.inputEmail(emailError);
		 loginPage.inputPassword(password);
		 
		 loginPage.clickToLoginBtn();
		 
		 Assert.assertEquals(loginPage.getErrorMessageAtNotRegisterEmailTxb(), "Login was unsuccessful."+
				 					" Please correct the errors and try again.\nNo customer account found");
	}

	//@Test
	public void TC_04_Login_with_valid_email_and_empty_password() {
		loginPage.clickToLoginLink();
		loginPage.inputEmail(email);
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getErrorMessageAtNotRegisterEmailTxb(), "Login was unsuccessful. "
				+ "Please correct the errors and try again.\nThe credentials provided are incorrect");

	}
	//@Test
	public void TC_05_Login_with_valid_email_and_invalid_password() {
		 loginPage.clickToLoginLink();
		 loginPage.inputEmail(emailError);
		 loginPage.inputPassword(passwordError);
		 
		 loginPage.clickToLoginBtn();
		 Assert.assertEquals(loginPage.getErrorMessageAtNotRegisterEmailTxb(), "Login was unsuccessful. "
					+ "Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	//@Test
	public void TC_06_Login_with_valid_email_and_valid_password() {
		 loginPage.clickToLoginLink();
		 loginPage.inputEmail(email);
		 loginPage.inputPassword(password);
		 
		 loginPage.clickToLoginBtn();
	}
	
	
	
	@AfterClass
	public void afterClas() {
		driver.quit();
	}
}
