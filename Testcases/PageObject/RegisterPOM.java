package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.HomePageObject;
import PageObject.RegisterPageObject;

public class RegisterPOM {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClassABC() {
		// Khai báo chromedriver
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		// Khởi tạo driver để điều khiển browser
		driver = new ChromeDriver();
		// Set timeout để tìm element
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		driver.get("https://demo.nopcommerce.com/");

	}

	// @Test
	public void TC_01_Empty_data() {
		homePage.clickToRegisterLink();
		registerPage.clickToRegisterBtn();
		Assert.assertEquals(registerPage.getErrMessageAtFirstNametbx(), "First name is required.");
		Assert.assertEquals(registerPage.getErrMessageAtFirstNametbx(), "First name is required.");
		Assert.assertEquals(registerPage.getErrMessageAtLastNametbx(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrMessageAtEmailtbx(), "Email is required.");
		Assert.assertEquals(registerPage.getErrMessageAtPasswordtbx(), "Password is required.");
		Assert.assertEquals(registerPage.getErrMessageAtConfirmPasswordtbx(), "Password is required.");

	}

	// @Test
	public void TC_02_Register_invalid_email() {

		homePage.clickToRegisterLink();

		registerPage.inputWrongEmail();
		registerPage.inputLastName();
		registerPage.inputWrongEmail();
		registerPage.inputPassword();
		registerPage.inputConfirmPassword();

		registerPage.clickToRegisterBtn();

		Assert.assertEquals(registerPage.getErrMessageAtEmailtbx(), "Wrong email");
	}

	// @Test
	public void TC_03_Register_valid_information() {
		homePage.clickToRegisterLink();

		registerPage.inputWrongEmail();
		registerPage.inputLastName();
		registerPage.inputEmail();
		registerPage.inputPassword();
		registerPage.inputConfirmPassword();

		registerPage.clickToRegisterBtn();
	}

	// @Test
	public void TC_04_Register_exist_email() {
		homePage.clickToRegisterLink();

		registerPage.inputWrongEmail();
		registerPage.inputLastName();
		registerPage.inputEmail();
		registerPage.inputPassword();
		registerPage.inputConfirmPassword();

		registerPage.clickToRegisterBtn();

		Assert.assertEquals(registerPage.getErrMessageExitsEmail(), "The specified email already exists");
	}

	 @Test
	public void TC_05_Password_smaller_6_characters() {
		homePage.clickToRegisterLink();

		registerPage.inputWrongEmail();
		registerPage.inputLastName();
		registerPage.inputEmail();
		registerPage.inputWrongPassword();
		registerPage.inputConfirmPassword();
		Assert.assertEquals(registerPage.getErrMessageAtPasswordtbx(), "Password must meet the following rules:\n"

				+ "must have at least 6 characters");

	}

	@Test
	public void TC_06_Password_not_match_Confirm_Password() {
		homePage.clickToRegisterLink();

		registerPage.inputWrongEmail();
		registerPage.inputLastName();
		registerPage.inputEmail();
		registerPage.inputWrongPassword();
		registerPage.inputWrongConfirmPassword();
		registerPage.clickToRegisterBtn();
		Assert.assertEquals(registerPage.getErrMessageAtConfirmPasswordtbx(),
				"The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClas() {
		driver.quit();
	}
}
