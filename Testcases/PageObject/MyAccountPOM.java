package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.MyAccountObject;

public class MyAccountPOM {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	MyAccountObject myAccountPage;
	LoginPageObject loginPage;
	/* My account */
	String email = "automationfc.vn@gmail.com";
	String firstName = "Automation";
	String lastName = "FC";
	String companyName = "Automation FC";
	String month = "January";
	String day = "1";
	String year = "1999";
	/* Login */
	String emailLogin = "automationfc.vn@gmail.com";
	String passwordLogin = "123123";
	/* Address */
	String firstNameAddr = "Automation";
	String lastNameAddr = "FC";
	String emailAddr = "automationfc.vn@gmail.com";
	String companyAddr = "Automation FC";
	String countryAddr = "Vietnam";
	String cityAddr = "Da Nang";
	String addr1 = "123/04 Le Lai";
	String addr2 = "234/ 05 Hai Phong";
	String zipCode = "550000";
	String phoneNum = "0123456789";
	String faxNum = "0987654321";
	/* Change password */
	String oldPassword = "123123";
	String newPassword = "123456";
	String confirmPassword = "123456";
	/* Review product */
	String reviewTitle = "AB";
	String reviewText = "AJSHDJASHJS\nkkajdkjasdkjkajr";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		homePage = new HomePageObject(driver);
		myAccountPage = new MyAccountObject(driver);
		loginPage = new LoginPageObject(driver);

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

	}
	@BeforeMethod
	public void Pre_condition_Login() {

		loginPage.clickToLoginLink();

		loginPage.inputEmail(emailLogin);
		loginPage.inputPassword(passwordLogin);
		loginPage.clickToLoginBtn();
		sleepInSecond(2);

	}

	//@Test
	public void TC_01_Update_info() {

		
		homePage.clickMyAccountLink();
		myAccountPage.checkGenderCheckBox();

		myAccountPage.updateFirstName(firstName);
		myAccountPage.updateLastName(lastName);
		myAccountPage.updateDayOfBirth(day);
		myAccountPage.updateMonthOfBirth(month);
		myAccountPage.updateYearOfBirth(year);
		myAccountPage.updateEmail(email);
		myAccountPage.updateCompanyName(companyName);
		myAccountPage.clickSaveBtn();

		Assert.assertEquals(myAccountPage.popUpSuccessUpdated(), "The customer info has been updated successfully.");
	}

	//@Test
	public void TC_01_Verify_info() {
		

		homePage.clickMyAccountLink();
		myAccountPage.getTextAtFirstNameTxb();
		Assert.assertEquals(myAccountPage.getTextAtFirstNameTxb(), "Automation");
		Assert.assertEquals(myAccountPage.getTextAtLastNameTxb(), "FC");
		Assert.assertEquals(myAccountPage.getTextAtCompanyNameTxb(), "Automation FC");

	}

	// @Test
	public void TC_02_Address() {
		loginPage.clickToLoginLink();

		loginPage.inputEmail(emailLogin);
		loginPage.inputPassword(passwordLogin);
		loginPage.clickToLoginBtn();

		homePage.clickMyAccountLink();

		myAccountPage.clickAddressLink();
		myAccountPage.clickAddNew();
		myAccountPage.inputFirstNameAtAddress(firstNameAddr);
		myAccountPage.inputLastNameAtAddress(lastNameAddr);
		myAccountPage.inputEmailAtAddress(emailAddr);
		myAccountPage.inputCompanyAtAddress(companyAddr);
		// myAccountPage.inputCountryAtAddress(countryAddr);
		myAccountPage.inputCityAtAddress(cityAddr);
		myAccountPage.inputAddr1AtAddress(addr1);
		myAccountPage.inputAddr2AtAddress(addr2);
		myAccountPage.inputZipCodeAtAddress(zipCode);
		myAccountPage.inputPhoneNumAtAddress(phoneNum);
		myAccountPage.inputFaxNumAtAddress(faxNum);

		myAccountPage.clickSaveBtnAtAddressLink();

	}

	//@Test
	public void TC_03_Update_Password() {
		loginPage.clickToLoginLink();

		loginPage.inputEmail(emailLogin);
		loginPage.inputPassword(passwordLogin);
		loginPage.clickToLoginBtn();

		homePage.clickMyAccountLink();
		myAccountPage.clickToChangePasswordLink();

		myAccountPage.inputOldPassword(oldPassword);
		myAccountPage.inputNewPassword(newPassword);
		myAccountPage.inputConfirmPassword(confirmPassword);
		myAccountPage.changePasswordBtn();

	}
	//@Test
	public void TC_04_My_Product_Review_Add_Review() {
		loginPage.clickToLoginLink();

		loginPage.inputEmail(emailLogin);
		loginPage.inputPassword(passwordLogin);
		loginPage.clickToLoginBtn();
		
		homePage.clickToPictureProduct();
		homePage.clickToAddYourReview();
		
		homePage.inputReviewTitle(reviewTitle);
		homePage.inputReviewText(reviewText);
		homePage.checkRatingRadio();
		
		homePage.clickSubmitReviewBtn();
	}
	//@Test
	public void TC_04_My_Product_Review_Verify() {
		loginPage.clickToLoginLink();

		loginPage.inputEmail(emailLogin);
		loginPage.inputPassword(passwordLogin);
		loginPage.clickToLoginBtn();

		homePage.clickMyAccountLink();
		myAccountPage.clickToMyProductReviewLink();
		Assert.assertEquals(myAccountPage.getTextReview(), "AJSHDJASHJS\nkkajdkjasdkjkajr");
		Assert.assertEquals(myAccountPage.getTextProductLink(), "Build your own computer");
	}
	public void sleepInSecond(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
