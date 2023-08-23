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
import PageObject.RegisterPageObject;

public class SearchAdvancedSearchPOM {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	ProductSearchPageObject searchPage;
	LoginPageObject loginPage;
	
	
	/* Login */
	String emailLogin = "automationfc.vn@gmail.com";
	String passwordLogin = "123123";
	/* Search */
	String errorDataAtSearchTxb = "Macbook Pro 2050";
	String relativeDataSearch = "Lenovo";
	String absoluteDataSearch = "ThinkPad X1 Carbon";
	
	@BeforeClass
	public void beforeClassABC() {
		// Khai báo chromedriver
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		// Khởi tạo driver để điều khiển browser
		driver = new ChromeDriver();
		// Set timeout để tìm element
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		searchPage = new ProductSearchPageObject(driver);
		loginPage = new LoginPageObject(driver);
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

	}
	
	@BeforeMethod
	public void Login() {
		 loginPage.clickToLoginLink();
		 
		 loginPage.inputEmail(emailLogin);
		 loginPage.inputPassword(passwordLogin);
		 
		 loginPage.clickToLoginBtn();
		 
	}
	//@Test
	public void TC_01_Search_with_empty_data() {
		
		 searchPage.clickSearchBtn();
		 Assert.assertEquals(searchPage.getErrMessageWithEmptyData(), " Please enter some search keyword");
	}
	//@Test
	public void TC_02_Search_with_not_exits_data() {
		
		 
		 searchPage.inputDataAtSearchTxb(errorDataAtSearchTxb);
		 searchPage.clickSearchBtn();
		 
		 Assert.assertEquals(searchPage.getTextExitsProductResult(), "No products were found that matched your criteria.");
	}
	//@Test
	public void TC_03_Search_with_product_name_relatively() {
		 loginPage.clickToLoginLink();
		 
		 loginPage.inputEmail(emailLogin);
		 loginPage.inputPassword(passwordLogin);
		 
		 loginPage.clickToLoginBtn();
		 
		 searchPage.inputDataAtSearchTxb(relativeDataSearch);
		 searchPage.clickSearchBtn();
		 
		 searchPage.verifyProductsNameRelative();
	}
	//@Test
	public void TC_04_Search_with_product_name_absolutely() {
		 loginPage.clickToLoginLink();
		 
		 loginPage.inputEmail(emailLogin);
		 loginPage.inputPassword(passwordLogin);
		 
		 loginPage.clickToLoginBtn();
		 
		 searchPage.inputDataAtSearchTxb(absoluteDataSearch);
		 searchPage.clickSearchBtn();
		 
		 searchPage.verifyProductsNameAbsolutely();
	}

	
	@AfterClass
	public void afterClas() {
		driver.quit();
	}
}
