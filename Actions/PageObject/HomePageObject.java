package PageObject;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageObject.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	public  HomePageObject (WebDriver mappingDriver) {
		this.driver = mappingDriver;
	}
	public void clickToRegisterLink() {
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}
	public void clickMyAccountLink() {
		clickToElement(driver, HomePageUI.MY_ACOUNT_LINK);
	}
	public void clickToPictureProduct() {
		clickToElement(driver, HomePageUI.PICTURE_PRODUCT);
		
	}
	public void clickToAddYourReview() {
		clickToElement(driver, HomePageUI.ADD_YOUR_REVIEW_LINK);
		
	}
	public void inputReviewTitle(String text) {
		
		senKeysElement(driver, HomePageUI.REVIEW_TITLE_TBX, text);
		
	}
	public void inputReviewText(String text) {
		senKeysElement(driver, HomePageUI.REVIEW_TEXT_TBX, text);
		
	}
	public void checkRatingRadio() {
		checkTheCheckboxOrRadio(driver, HomePageUI.CHECK_RATING_RADIO);
	}
	public void clickSubmitReviewBtn() {
		clickToElement(driver, HomePageUI.SUBMIT_REVIEW_BTN);
		
	}
	public DesktopPageObject selectDesktopInComputerDropdown() {
		moveToElement(driver, HomePageUI.COMPUTERS_DROPDOWN);
		clickToElement(driver, HomePageUI.DESKTOP_IN_COMPUTERS_DROPDOWN);
		return PageGeneratorManager.getDesktopPage(driver);
	}
	
}
