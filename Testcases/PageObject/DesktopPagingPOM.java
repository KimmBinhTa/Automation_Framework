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

public class DesktopPagingPOM {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	DesktopPageObject desktopPage;

	String sortAtoZ = "Name: A to Z";
	String sortZtoA = "Name: Z to A";
	String sortHightoLow = "Price: Low to High";
	String sortLowtoHigh = "Price: High to Low";

	@BeforeClass
	public void beforeClass() {
		// Khai báo chromedriver
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		// Khởi tạo driver để điều khiển browser
		driver = new ChromeDriver();
		// Set timeout để tìm element
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		
		homePage = new HomePageObject(driver);
		

	}

	@Test
	public void TC_01_Sort_A_to_Z() {
		// Step 1: Select Desktop in Computer dropdown
		desktopPage = homePage.selectDesktopInComputerDropdown();
		// Step 2: Select Name A-Z in Sort by dropdown
		desktopPage.selectAtoZinSortDropdown(sortAtoZ);
		// Step 3: Verify product name according to increading A-Z
		Assert.assertTrue(desktopPage.compareAtoZSort());

	}

	//@Test
	public void TC_02_Sort_Z_to_A() {
		// Step 1: Select Desktop in Computer dropdown
		desktopPage = homePage.selectDesktopInComputerDropdown();
		// Step 2: Select Name Z-A in Sort by dropdown
		desktopPage.selectZtoAinSortDropdown(sortZtoA);
		// Step 3: Verify product name according to decreading Z-A
		Assert.assertTrue(desktopPage.compareZtoASort());

	}

	//@Test
	public void TC_03_Sort_High_to_Low() {
		// Step 1: Select Desktop in Computer dropdown
		desktopPage = homePage.selectDesktopInComputerDropdown();
		// Step 2: Select Name Z-A in Sort by dropdown
		desktopPage.selectAtoZinSortDropdown(sortHightoLow);
		// Step 3: Verify product name according High to Lodun
		desktopPage.getPriceSortHightoLowBefore();
		desktopPage.getPriceSortHightoLowAfter();
		Assert.assertTrue(desktopPage.compareHightoLow());

	}

	@AfterClass
	public void afterClas() {
		driver.quit();
	}
}
