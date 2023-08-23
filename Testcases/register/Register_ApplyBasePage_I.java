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

public class Register_ApplyBasePage_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage = new BasePage();
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
		basePage.getUrl(driver, "https://demo.nopcommerce.com/");
	}

	 @Test
	public void TC_01_Empty_data() {

		basePage.clickToElement(driver,"//a[@class='ico-register']");

		
		basePage.clickToElement(driver,"//button[@id='register-button']");
		
		
		Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	//@Test
	public void TC_02_Register_invalid_email() {
		basePage.clickToElement(driver,"//a[@class='ico-register']");
		
		basePage.checkTheCheckboxOrRadio(driver, "//input[@id='gender-male']");
		
		basePage.senKeysElement(driver,"//input[@id='FirstName']",firstName);
		basePage.senKeysElement(driver,"//input[@id='LastName']",lastName);
		
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthDay']", "4");
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		

		basePage.senKeysElement(driver,"//input[@id='Email']","aaaa123");
		basePage.senKeysElement(driver,"//input[@id='Password']",password);
		
		Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='Email-error']"), "Wrong email");
	

		basePage.senKeysElement(driver,"//input[@id='ConfirmPassword']",confirmPassword);

	}

	@Test
	public void TC_03_Register_valid_information() {
		basePage.clickToElement(driver,"//a[@class='ico-register']");
		
		basePage.checkTheCheckboxOrRadio(driver, "//input[@id='gender-male']");
		
		basePage.senKeysElement(driver,"//input[@id='FirstName']",firstName);
		basePage.senKeysElement(driver,"//input[@id='LastName']",lastName);
		
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthDay']", "4");
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		

		basePage.senKeysElement(driver,"//input[@id='Email']",email);
		basePage.senKeysElement(driver,"//input[@id='Password']",password);
		
		basePage.senKeysElement(driver,"//input[@id='ConfirmPassword']",password);
		basePage.clickToElement(driver,"//button[@id='register-button']");

	}

	//@Test
	public void TC_04_Register_exist_email() {
		basePage.clickToElement(driver,"//a[@class='ico-register']");
		
		basePage.checkTheCheckboxOrRadio(driver, "//input[@id='gender-male']");
		
		basePage.senKeysElement(driver,"//input[@id='FirstName']",firstName);
		basePage.senKeysElement(driver,"//input[@id='LastName']",lastName);
		
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthDay']", "4");
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		

		basePage.senKeysElement(driver,"//input[@id='Email']",email);
		basePage.senKeysElement(driver,"//input[@id='Password']",password);
		
		basePage.senKeysElement(driver,"//input[@id='ConfirmPassword']",password);
		basePage.clickToElement(driver,"//button[@id='register-button']");
		Assert.assertEquals(basePage.getTextElement(driver, "//div[contains(@class,'summary-errors')]//li"),
				"The specified email already exists");

	}

	//@Test
	public void TC_05_Password_smaller_6_characters() {
		basePage.clickToElement(driver,"//a[@class='ico-register']");
		
		basePage.checkTheCheckboxOrRadio(driver, "//input[@id='gender-male']");
		
		basePage.senKeysElement(driver,"//input[@id='FirstName']",firstName);
		basePage.senKeysElement(driver,"//input[@id='LastName']",lastName);
		
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthDay']", "4");
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		

		basePage.senKeysElement(driver,"//input[@id='Email']",email);
		basePage.senKeysElement(driver,"//input[@id='Password']","123");
		
		basePage.senKeysElement(driver,"//input[@id='ConfirmPassword']","123");
		Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='Password-error']"),
				"Password must meet the following rules:\n"

						+ "must have at least 6 characters");

	}

	//@Test
	public void TC_06_Password_not_match_Confirm_Password() {
		basePage.clickToElement(driver,"//a[@class='ico-register']");
		
		basePage.checkTheCheckboxOrRadio(driver, "//input[@id='gender-male']");
		
		basePage.senKeysElement(driver,"//input[@id='FirstName']",firstName);
		basePage.senKeysElement(driver,"//input[@id='LastName']",lastName);
		
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthDay']", "4");
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		basePage.defaultItemDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		

		basePage.senKeysElement(driver,"//input[@id='Email']",email);
		basePage.senKeysElement(driver,"//input[@id='Password']","1234567");
		
		basePage.senKeysElement(driver,"//input[@id='ConfirmPassword']","1233456");
		basePage.clickToElement(driver,"//button[@id='register-button']");
		Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='ConfirmPassword-error']"), 
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
