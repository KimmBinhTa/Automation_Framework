package PageObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.BasePage;

public class DesktopPageObject extends BasePage {
	WebDriver driver;

	public DesktopPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// A-Z
	private static String allProductBeforeAtoZ[];
	private static String allProductAfterAtoZ[];
	// Z-A
	private static String allProductBeforeZtoA[];
	private static String allProductAfterZtoA[];
	// High-Low
	private static String expectedPriceSortHightoLow[] = new String[20];
	private static String actualPriceSortHightoLow[] = new String[20];

	public void selectAtoZinSortDropdown(String AtoZ) {
		
		getTextAtSortByIncreading();

		defaultItemDropdown(driver, DesktopPagingUI.SORT_DROPDOWN, AtoZ);
		
		getTextAtSortByAtoZ();
		
	}

	// ================================A TO Z==========================================//
	private void getTextAtSortByIncreading() {
		List<WebElement> allItems = getElements(driver, DesktopPagingUI.SORT_RESULT);
		int size = getElementsSize(driver, DesktopPagingUI.SORT_RESULT);
		allProductBeforeAtoZ = new String[size];
		for(int i = 0; i < allProductBeforeAtoZ.length; i++) {
			allProductBeforeAtoZ[i] = new String();
		}
		int index = 0;
		for (WebElement element : allItems) {
			allProductBeforeAtoZ[index] = element.getText();
			index++;
		}
		for (int i = 0; i < allProductBeforeAtoZ.length - 1; i++) {

			for (int j = i + 1; j < allProductBeforeAtoZ.length; j++) {
				if (allProductBeforeAtoZ[i].compareTo(allProductBeforeAtoZ[j]) > 0) {
					String temp = allProductBeforeAtoZ[i];
					allProductBeforeAtoZ[i] = allProductBeforeAtoZ[j];
					allProductBeforeAtoZ[j] = temp;
				}
			}
		}
		
	}

	private void getTextAtSortByAtoZ() {
		List<WebElement> allItems = getElements(driver, DesktopPagingUI.A_TO_Z_IN_SORT_RESULT);
		int size = getElementsSize(driver, DesktopPagingUI.A_TO_Z_IN_SORT_RESULT);
		allProductAfterAtoZ = new String[size];
		
		for(int i = 0; i < allProductAfterAtoZ.length; i++) {
			allProductAfterAtoZ[i] = new String();
		}
		int index = 0;
		for (WebElement element : allItems) {
			allProductAfterAtoZ[index] = element.getText();
			index++;
		}

		
	}

	public boolean compareAtoZSort() {
		
		return Arrays.equals(allProductBeforeAtoZ, allProductAfterAtoZ);
	}

	// ================================Z TO A==========================================//
	public void selectZtoAinSortDropdown(String ZtoA) {
		getTextAtSortByDecreading();
		
		defaultItemDropdown(driver, DesktopPagingUI.SORT_DROPDOWN, ZtoA);
		
		getTextAtSortByZtoA();
		
	}
	private void getTextAtSortByDecreading() {
		List<WebElement> allItems = getElements(driver, DesktopPagingUI.SORT_RESULT);
		int size = getElementsSize(driver, DesktopPagingUI.SORT_RESULT);
		allProductBeforeAtoZ = new String [size];
		int index = 0;
		//Khai bao
		for(int i = 0; i < allProductBeforeZtoA.length; i++) {
			allProductBeforeZtoA[i] = new String();
		}
		for (WebElement element : allItems) {
			allProductBeforeZtoA[index] = element.getText();
			index++;
		}
		//Sort
		for (int i = 0; i < allProductBeforeZtoA.length - 1; i++) {
			for (int j = i + 1; j < allProductBeforeZtoA.length; j++) {
				if (allProductBeforeZtoA[i].compareTo(allProductBeforeZtoA[j]) < 0) {
					String temp = allProductBeforeZtoA[i];
					allProductBeforeZtoA[i] = allProductBeforeZtoA[j];
					allProductBeforeZtoA[j] = temp;
				}
			}
		}
		

	}

	private void getTextAtSortByZtoA() {
		List<WebElement> allItems = getElements(driver, DesktopPagingUI.Z_TO_A_IN_SORT_RESULT);
		int size = getElementsSize(driver, DesktopPagingUI.Z_TO_A_IN_SORT_RESULT);
		allProductAfterZtoA = new String [size];
		int index = 0;
		//Khai bao
		for(int i = 0; i < allProductAfterZtoA.length; i++) {
			allProductAfterZtoA[i] = new String();
		}
		for (WebElement element : allItems) {
			allProductAfterZtoA[index] = element.getText();
			index++;
		}

		

	}

	public boolean compareZtoASort() {
		return Arrays.equals(allProductBeforeZtoA, allProductAfterZtoA);

	}
	// ================================High to Low==========================================//

	public void getPriceSortHightoLowBefore() {
		int sizeOfItems = getElementsSize(driver, DesktopPagingUI.SORT_RESULT);
		String allProductsHightoLow[][] = new String[sizeOfItems][2];
		List<WebElement> allItems = getElements(driver, DesktopPagingUI.SORT_RESULT);
		// Add product
		int indexRow = 0;
		int indexCol = 0;
		for (WebElement element : allItems) {
			allProductsHightoLow[indexRow][indexCol] = element.getText();
			indexRow++;
		}
		// Add price
		indexRow = 0;
		indexCol = 1;
		for (WebElement element : allItems) {
			allProductsHightoLow[indexRow][indexCol] = element.getText();
			indexCol++;
		}

		// Format price to sort
		for (int i = 0; i < 3; i++) {
			allProductsHightoLow[i][1] = allProductsHightoLow[i][1].replace("$", "");
			allProductsHightoLow[i][1] = allProductsHightoLow[i][1].replace(",", "");
		}
		// Sort
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (Double.parseDouble(allProductsHightoLow[i][1]) < Double.parseDouble(allProductsHightoLow[j][1])) {
					String temp[] = allProductsHightoLow[i];
					allProductsHightoLow[i] = allProductsHightoLow[j];
					allProductsHightoLow[j] = temp;
				}
			}
		}
		// get Price array
		for (int i = 0; i < 2; i++) {
			expectedPriceSortHightoLow[i] = allProductsHightoLow[i][0];
		}
	}

	public void getPriceSortHightoLowAfter() {
		int sizeOfItems = getElementsSize(driver, DesktopPagingUI.HIGH_TO_LOW_IN_SORT_RESULT);
		String allProductsHightoLow[][] = new String[sizeOfItems][2];
		List<WebElement> allItems = getElements(driver, DesktopPagingUI.HIGH_TO_LOW_IN_SORT_RESULT);
		// Add product
		int indexRow = 0;
		int indexCol = 0;
		for (WebElement element : allItems) {
			allProductsHightoLow[indexRow][indexCol] = element.getText();
			indexRow++;
		}
		// Add price
		indexRow = 0;
		indexCol = 1;
		for (WebElement element : allItems) {
			allProductsHightoLow[indexRow][indexCol] = element.getText();
			indexCol++;
		}

		// get Price array
		for (int i = 0; i < 2; i++) {
			actualPriceSortHightoLow[i] = allProductsHightoLow[i][0];
		}
	}

	public boolean compareHightoLow() {
		return Arrays.equals(expectedPriceSortHightoLow, actualPriceSortHightoLow);
	}

	

}
