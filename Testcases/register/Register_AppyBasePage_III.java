package register;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.BasePage;

public class Register_AppyBasePage_III extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	String firstName = "Alex";
	String lastName = "Doll";
	String email = "alex1@gmail.com";
	String password = "12345678";
	String confirmPassword = "12345678";

	@BeforeClass
	public void beforeClassABC() {
		// Khai báo chromedriver
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		// Khởi tạo driver để điều khiển browser
		driver = new ChromeDriver();
		// Set timeout để tìm element
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		getUrl(driver, "https://demo.nopcommerce.com/");
	}

	 @Test
	public void TC_01_Empty_data() {

		clickToElement(driver,"//a[@class='ico-register']");

		
		clickToElement(driver,"//button[@id='register-button']");
		
		
		Assert.assertEquals(getTextElement(driver,"//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getTextElement(driver,"//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getTextElement(driver,"//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getTextElement(driver,"//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getTextElement(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	//@Test
	public void TC_02_Register_invalid_email() {
		clickToElement(driver,"//a[@class='ico-register']");
		
		checkTheCheckboxOrRadio(driver, "//input[@id='gender-male']");
		
		senKeysElement(driver,"//input[@id='FirstName']",firstName);
		senKeysElement(driver,"//input[@id='LastName']",lastName);
		
		defaultItemDropdown(driver, "//select[@name='DateOfBirthDay']", "4");
		defaultItemDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		defaultItemDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		

		senKeysElement(driver,"//input[@id='Email']","aaaa123");
		senKeysElement(driver,"//input[@id='Password']",password);
		
		Assert.assertEquals(getTextElement(driver,"//span[@id='Email-error']"), "Wrong email");
	

		senKeysElement(driver,"//input[@id='ConfirmPassword']",confirmPassword);

	}

	@Test
	public void TC_03_Register_valid_information() {
		clickToElement(driver,"//a[@class='ico-register']");
		
		checkTheCheckboxOrRadio(driver, "//input[@id='gender-male']");
		
		senKeysElement(driver,"//input[@id='FirstName']",firstName);
		senKeysElement(driver,"//input[@id='LastName']",lastName);
		
		defaultItemDropdown(driver, "//select[@name='DateOfBirthDay']", "4");
		defaultItemDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		defaultItemDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		

		senKeysElement(driver,"//input[@id='Email']",email);
		senKeysElement(driver,"//input[@id='Password']",password);
		
		senKeysElement(driver,"//input[@id='ConfirmPassword']",password);
		clickToElement(driver,"//button[@id='register-button']");

	}

	//@Test
	public void TC_04_Register_exist_email() {
		clickToElement(driver,"//a[@class='ico-register']");
		
		checkTheCheckboxOrRadio(driver, "//input[@id='gender-male']");
		
		senKeysElement(driver,"//input[@id='FirstName']",firstName);
		senKeysElement(driver,"//input[@id='LastName']",lastName);
		
		defaultItemDropdown(driver, "//select[@name='DateOfBirthDay']", "4");
		defaultItemDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		defaultItemDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		

		senKeysElement(driver,"//input[@id='Email']",email);
		senKeysElement(driver,"//input[@id='Password']",password);
		
		senKeysElement(driver,"//input[@id='ConfirmPassword']",password);
		clickToElement(driver,"//button[@id='register-button']");
		Assert.assertEquals(getTextElement(driver, "//div[contains(@class,'summary-errors')]//li"),
				"The specified email already exists");

	}

	//@Test
	public void TC_05_Password_smaller_6_characters() {
		clickToElement(driver,"//a[@class='ico-register']");
		
		checkTheCheckboxOrRadio(driver, "//input[@id='gender-male']");
		
		senKeysElement(driver,"//input[@id='FirstName']",firstName);
		senKeysElement(driver,"//input[@id='LastName']",lastName);
		
		defaultItemDropdown(driver, "//select[@name='DateOfBirthDay']", "4");
		defaultItemDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		defaultItemDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		

		senKeysElement(driver,"//input[@id='Email']",email);
		senKeysElement(driver,"//input[@id='Password']","123");
		
		senKeysElement(driver,"//input[@id='ConfirmPassword']","123");
		Assert.assertEquals(getTextElement(driver,"//span[@id='Password-error']"),
				"Password must meet the following rules:\n"

						+ "must have at least 6 characters");

	}

	//@Test
	public void TC_06_Password_not_match_Confirm_Password() {
		clickToElement(driver,"//a[@class='ico-register']");
		
		checkTheCheckboxOrRadio(driver, "//input[@id='gender-male']");
		
		senKeysElement(driver,"//input[@id='FirstName']",firstName);
		senKeysElement(driver,"//input[@id='LastName']",lastName);
		
		defaultItemDropdown(driver, "//select[@name='DateOfBirthDay']", "4");
		defaultItemDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		defaultItemDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		

		senKeysElement(driver,"//input[@id='Email']",email);
		senKeysElement(driver,"//input[@id='Password']","1234567");
		
		senKeysElement(driver,"//input[@id='ConfirmPassword']","1233456");
		clickToElement(driver,"//button[@id='register-button']");
		Assert.assertEquals(getTextElement(driver,"//span[@id='ConfirmPassword-error']"), 
				"The password and confirmation password do not match.");
		

	}

	public void sleepInSecond(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (Exception e) {

			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
