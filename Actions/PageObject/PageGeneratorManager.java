package PageObject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePage (WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static DesktopPageObject getDesktopPage (WebDriver driver) {
		return new DesktopPageObject(driver);
	}
}
