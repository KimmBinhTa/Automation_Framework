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

public class BasePageFactory {
	public static BasePageFactory getBasePage() {
		return new BasePageFactory();
	}

	public void getUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void clear(WebDriver driver, WebElement element) {
		element.clear();
	}

	public void clickToElement(WebElement element) {
		element.click();
	}

	public void senKeysElement(WebDriver driver, WebElement element, String text) {
		element.sendKeys(text);
	}

	public void defaultItemDropdown(WebDriver driver, WebElement element, String expectedItem) {
		Select itemelement = new Select(element);
		itemelement.selectByVisibleText(expectedItem);

	}

	public void selectItemCustomDropdown(WebDriver driver, WebElement parentElement, List<WebElement> itemElement,
			String expectedItem) {

		scrollToCenterPage(driver, parentElement);

		waitForElementClickable(driver, parentElement);

		parentElement.click();

		List<WebElement> allItems = itemElement;
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedItem)) {
				scrollToCenterPage(driver, item);
				waitForElementClickable(driver, item);
				item.click();
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, WebElement element, String attributeName) {

		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebElement element) {
		return element.getText();
	}

	public String getCssValue(WebDriver driver, WebElement element, String cssValue) {
		return element.getCssValue(cssValue);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementsSize(WebDriver driver, List<WebElement> element) {
		return element.size();
	}

	public void checkTheCheckboxOrRadio(WebDriver driver, WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, WebElement element) {
		if (element.isSelected()) {
			element.click();
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

	public void switchToFrame_Iframe(WebDriver driver, String element) {
		driver.switchTo().frame(element);

	}

	public void switchToDefaultContent(WebDriver driver, String itemelement) {
		driver.switchTo().defaultContent();

	}

	public void doubleClickToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}

	public void clickAndHoverMouseToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).perform();

	}

	public void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();

	}

	public void dragAndDrop(WebDriver driver, WebElement sourceelement, WebElement targetelement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceelement, targetelement).perform();

	}

	public void sendKeyboardToElement(WebDriver driver, WebElement element, Keys key) {

		Actions action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForAlertPresence(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void getUrlByJavascript(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(url);
	}

	public void scrollToCenterPage(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", element);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollToBottomElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void hightlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px groove red’", element);
	}

	public void removeAttributeOfElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled');", element);
	}

	public String verifyTextInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String sText = jsExecutor.executeScript("return document.documentElement.innerText;").toString();
		return sText;
	}

	public void getElementValidationMessage(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("return arguments[0].validationMessage;", element);

	}

	public void checkCheckboxByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		if (!element.isSelected()) {
			jsExecutor.executeScript("arguments[0].click();", element);
		}
	}

	public void unCheckCheckboxByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		if (element.isSelected()) {
			jsExecutor.executeScript("arguments[0].click();", element);
		}
	}

}
