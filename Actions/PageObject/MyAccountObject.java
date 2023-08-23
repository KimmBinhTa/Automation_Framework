package PageObject;

import java.awt.print.Printable;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageObject.HomePageUI;
import PageObject.MyAccountUI;

public class MyAccountObject extends BasePage{
	WebDriver driver;

	public MyAccountObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMyAccountLink() {
		clickToElement(driver, HomePageUI.MY_ACOUNT_LINK);
	}

	public void checkGenderCheckBox() {
		checkTheCheckboxOrRadio(driver, MyAccountUI.FEMALE_CHECKBOX);
	}

	public void updateFirstName(String firtName) {
		clear(driver, MyAccountUI.FIRST_NAME);
		senKeysElement(driver, MyAccountUI.FIRST_NAME, firtName);
	}

	public void updateLastName(String lastName) {
		clear(driver, MyAccountUI.LAST_NAME);
		senKeysElement(driver, MyAccountUI.LAST_NAME, lastName);
	}

	public void updateEmail(String email) {
		clear(driver, MyAccountUI.EMAIL);
		senKeysElement(driver, MyAccountUI.EMAIL, email);
	}
	public void updateCompanyName(String companyName) {
		clear(driver, MyAccountUI.COMPANY);
		senKeysElement(driver, MyAccountUI.COMPANY, companyName);
	}

	public void updateMonthOfBirth(String item) {
		defaultItemDropdown(driver, MyAccountUI.MONTH_OF_BIRTH_DROPDOWN, item);
	}

	public void updateYearOfBirth(String item) {
		
		defaultItemDropdown(driver, MyAccountUI.YEAR_OF_BIRTH_DROPDOWN, item);
	}
	public void updateDayOfBirth (String item) {
		
		defaultItemDropdown(driver, MyAccountUI.DAY_OF_BIRTH_DROPDOWN, item);
	}
	public void clickSaveBtn() {
		clickToElement(driver, MyAccountUI.SAVE_BTN);
	}
	public String getTextAtFirstNameTxb() {
		return getAttributeValue(driver, MyAccountUI.FIRST_NAME, "value");
		
	}
	public String getTextAtLastNameTxb() {
		return getAttributeValue(driver, MyAccountUI.LAST_NAME, "value");
	}
	public String getTextAtEmailTxb() {
		return getAttributeValue(driver, MyAccountUI.EMAIL,"value");
	}
	public String getTextAtCompanyNameTxb() {
		return getAttributeValue(driver, MyAccountUI.COMPANY,"value");
	}
	
	public String popUpSuccessUpdated() {
		return getTextElement(driver,MyAccountUI.POPUP_UPDATED_SUCCESS);
		
	}
	public void clickAddressLink() {
		clickToElement(driver, MyAccountUI.ADDRESS_LINK);
		
	}

	public void inputFirstNameAtAddress(String text) {
		 senKeysElement(driver, MyAccountUI.FIRST_NAME_ADDRESS, text);
		
	}

	public void inputLastNameAtAddress(String text) {
		 senKeysElement(driver, MyAccountUI.LAST_NAME_ADDRESS, text);
		
	}

	public void inputEmailAtAddress(String text) {
		senKeysElement(driver, MyAccountUI.EMAIL_ADDRESS, text);
		
	}

	public void inputCompanyAtAddress(String text) {
		senKeysElement(driver, MyAccountUI.COMPANY_NAME_ADDRESS, text);
		
	}

	public void inputCountryAtAddress(String text) {
		
		defaultItemDropdown(driver, MyAccountUI.COUNTRY_NAME_ADDRESS, text);
	}

	

	public void inputCityAtAddress(String text) {
		senKeysElement(driver, MyAccountUI.CITY_ADDRESS, text);
		
	}

	public void inputAddr1AtAddress(String text) {
		senKeysElement(driver, MyAccountUI.ADDR1_ADDRESS, text);
		
	}

	public void inputAddr2AtAddress(String text) {
		senKeysElement(driver, MyAccountUI.ADDR2_ADDRESS, text);
		
	}

	public void inputZipCodeAtAddress(String text) {
		senKeysElement(driver, MyAccountUI.ZIP_CODE_ADDRESS, text);
		
	}

	public void inputPhoneNumAtAddress(String text) {
		senKeysElement(driver, MyAccountUI.PHONE_NUM_ADDRESS, text);
		
	}

	public void inputFaxNumAtAddress(String text) {
		senKeysElement(driver, MyAccountUI.FAX_ADDRESS, text);
		
	}

	public void clickSaveBtnAtAddressLink(String text) {
		senKeysElement(driver, MyAccountUI.SAVE_BTN_ADDRESS, text);
		
	}

	public void clickSaveBtnAtAddressLink() {
		clickToElement(driver, MyAccountUI.SAVE_BTN_ADDRESS);
		
	}

	public void clickAddNew() {
		clickToElement(driver, MyAccountUI.ADD_NEW_BTN);
		
	}

	public void clickToChangePasswordLink() {
		scrollToBottomElement(driver, MyAccountUI.CHANGE_PASSWORD_LINK);
		waitForAlertPresence(driver, MyAccountUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountUI.CHANGE_PASSWORD_LINK);
		
	}

	public void inputOldPassword(String text) {
		senKeysElement(driver, MyAccountUI.OLD_PASSWORD, text);
		
	}

	public void inputNewPassword(String text) {
		senKeysElement(driver, MyAccountUI.NEW_PASSWORD, text);
		
	}

	public void inputConfirmPassword(String text) {
		senKeysElement(driver, MyAccountUI.CONFIRM_PASSWORD, text);
		
	}

	public void changePasswordBtn() {
		clickToElement(driver, MyAccountUI.CHANGE_PASSWORD_BTN);
		
	}

	public void clickToMyProductReviewLink() {
		clickToElement(driver, MyAccountUI.PRODUCT_REVIEW_LINK);
		
	}

	public String getTextReview() {
		return getTextElement(driver, MyAccountUI.REVIEW_TEXT);
	}

	public String getTextProductLink() {
		return getTextElement(driver, MyAccountUI.PRODUCT_LINK_TEXT);
	}

	
}
