package PageObject;

public class HomePageUI {
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	public static final String MY_ACOUNT_LINK = "//a[@class='ico-account']";
	
	public static final String PICTURE_PRODUCT = "//img[@alt='Picture of Build your own computer']";
	public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add your review']";
	public static final String REVIEW_TITLE_TBX = "//input[@id='AddProductReview_Title']";
	public static final String REVIEW_TEXT_TBX = "//textarea[@id='AddProductReview_ReviewText']";
	public static final String CHECK_RATING_RADIO = "//input[@id='addproductrating_4']";
	public static final String SUBMIT_REVIEW_BTN = "//button[@class='button-1 write-product-review-button']";
	public static final String COMPUTERS_DROPDOWN = "//ul[@class='sublist first-level']//parent::li/a";
	public static final String DESKTOP_IN_COMPUTERS_DROPDOWN = "//ul[@class='sublist first-level']//a";
}
