package PageObject;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageObject.HomePageUI;
import PageObject.LoginPageUI;

public class ProductSearchPageObject extends BasePage{
	WebDriver driver;

	public ProductSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSearchBtn() {
		clickToElement(driver, ProductSearchPageUI.SEARCH_BTN);
		
	}

	public void inputDataAtSearchTxb(String text) {
		senKeysElement(driver, ProductSearchPageUI.INVALID_SEARCH_TBX, text);
		
	}

	public String getTextExitsProductResult() {
		waitForElementVisible(driver, ProductSearchPageUI.EXITS_PRODUCT_RESULT_TEXT);
		return getTextElement(driver, ProductSearchPageUI.EXITS_PRODUCT_RESULT_TEXT);
	}
	
	public void verifyProductsNameRelative() {
		waitForElementVisible(driver, ProductSearchPageUI.LENOVO_THINKPAD_PRODUCT);
		waitForElementVisible(driver, ProductSearchPageUI.LENOVO_IDEA_PRODUCT);		
		getElementDisplay(driver,  ProductSearchPageUI.LENOVO_THINKPAD_PRODUCT);
		getElementDisplay(driver,  ProductSearchPageUI.LENOVO_IDEA_PRODUCT);
	}

	public void verifyProductsNameAbsolutely() {
		waitForElementVisible(driver, ProductSearchPageUI.THINKPAD_X1_PRODUCT);
		getElementDisplay(driver, ProductSearchPageUI.THINKPAD_X1_PRODUCT);
		
	}

	public String getErrMessageWithEmptyData() {
		waitForElementVisible(driver, getTextConfirmAlert(driver, ProductSearchPageUI.SEARCH_BTN));
		System.out.println(getTextConfirmAlert(driver, ProductSearchPageUI.SEARCH_BTN));
		return getTextConfirmAlert(driver, ProductSearchPageUI.SEARCH_BTN);
		
	}

//	public String getErrMessageWithEmptyData() {
//		
//		return getTextElement(driver, confirmAlert(driver, Search_AdvancedSearch_UI.SEARCH_BTN));
//	}
	
}
