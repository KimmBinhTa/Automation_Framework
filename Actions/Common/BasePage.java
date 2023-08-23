package Common;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void getUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	public void clear (WebDriver driver, String locator) {
		getElement(driver, locator).clear();
	}
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void senKeysElement(WebDriver driver, String locator, String text) {
		getElement(driver, locator).sendKeys(text);
	}

	public void defaultItemDropdown( WebDriver driver, String locator, String expectedItem) {
		Select itemLocator = new Select(getElement(driver, locator));
		
		itemLocator.selectByVisibleText(expectedItem);

	}

	public void selectItemInCustomDropdown(WebDriver driver, String itemLocator, String parentLocator,
			String expectedItem) {
		getElement(driver, parentLocator).click();
		for (WebElement item : getElements(driver, itemLocator)) {
			if (item.getText().equals(expectedItem)) {
				item.click();
				break;
			}
		}

	}
	public void confirmAlert(WebDriver driver, String locator) {
		getElement(driver, locator).click();
		Alert alert;
		alert = driver.switchTo().alert();
		alert.accept();
		
	}
	public String getTextConfirmAlert(WebDriver driver, String locator) {
		getElement(driver, locator).click();
		Alert alert;
		alert = driver.switchTo().alert();
		return alert.getText();
	}
	public boolean getElementDisplay(WebDriver driver,String locator) {
		return getElement(driver, locator).isDisplayed();
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {

		return getElement(driver, locator).getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}

	public String getCssValue(WebDriver driver, String locator, String cssValue) {
		return getElement(driver, locator).getCssValue(cssValue);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementsSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
		if (!getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		if (getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}

	public void switchToWindow(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String runWindow : allWindowIDs) {
			if (!runWindow.equals(parentID))
				;
			{
				driver.switchTo().window(runWindow);
				break;
			}
		}

	}

	public void switchToParentWindow(WebDriver driver, String parentID) {
		switchToWindow(driver, parentID);
	}

	public void switchToFrame_Iframe(WebDriver driver, String itemLocator) {
		driver.switchTo().frame(getElement(driver, itemLocator));

	}

	public void switchToDefaultContent(WebDriver driver, String itemLocator) {
		driver.switchTo().defaultContent();

	}


	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();

	}

	public void clickAndHoverMouseToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();

	}

	public void moveToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();

	}

	public void rightClick(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();

	}

	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();

	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {

		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForAlertPresence(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void getUrlByJavascript(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(url);
	}
	public void scrollToViewLocator(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", locator);
	}
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollToBottomElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void hightlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px groove red’", getElement(driver, locator));
	}

	public void removeAttributeOfElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled');", getElement(driver, locator));
	}

	public String verifyTextInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String sText = jsExecutor.executeScript("return document.documentElement.innerText;").toString();
		return sText;
	}

	public void getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));

	}

	public void checkCheckboxByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		if (!getElement(driver, locator).isSelected()) {
			jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
		}
	}

	public void unCheckCheckboxByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		if (getElement(driver, locator).isSelected()) {
			jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
		}
	}

	
	
	
}
