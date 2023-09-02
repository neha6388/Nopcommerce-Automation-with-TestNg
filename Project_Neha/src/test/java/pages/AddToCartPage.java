package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebTestBase;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utility;

public class AddToCartPage extends WebTestBase{
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]")
	WebElement addtoCart;
	@FindBy(xpath="//*[@id=\"bar-notification\"]/div/p")
	WebElement addToCartResult;
	@FindBy(xpath="//*[@id=\"topcartlink\"]")
	WebElement shoppingCartBtn;
	@FindBy(xpath="//*[@id=\"itemquantity11224\"]")
	WebElement qty;
	@FindBy(xpath="//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[7]/button")
	WebElement removeBtn;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div/div")
WebElement emptyCartResult;
	@FindBy(xpath="//*[@id=\"checkout_attribute_1\"]")
	WebElement giftWrappingDropDown;
	@FindBy(xpath="//*[@id=\"discountcouponcode\"]")
	WebElement couponCodeTB;
	@FindBy(xpath="//*[@id=\"applydiscountcouponcode\"]")
	WebElement couponCodeBtn;
	@FindBy(xpath="//*[@id=\"giftcardcouponcode\"]")
	WebElement giftCodeTB;
	@FindBy(xpath="//*[@id=\"applygiftcardcouponcode\"]")
	WebElement giftCodeBtn;
	@FindBy(xpath="//*[@id=\"shopping-cart-form\"]/div[3]/div[1]/div/div[1]/div[4]")
	WebElement resultCouponCode;
	@FindBy(xpath="//*[@id=\"shopping-cart-form\"]/div[3]/div[1]/div/div[2]/div[4]")
	WebElement resultGiftCode;
	@FindBy(xpath="//*[@id=\"termsofservice\"]")
	WebElement checkbox;
	@FindBy(xpath="//*[@id=\"checkout\"]")
	WebElement checkoutBtn;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")
	WebElement checkoutAsGuestBtn;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_FirstName\"]")
	WebElement fname  ;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_LastName\"]")
	WebElement  lname;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_Email\"]")
	WebElement email ;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_Company\"]")
	WebElement company ;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_CountryId\"]")
	WebElement cDropDown ;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_StateProvinceId\"]")
	WebElement sdropdown ;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_City\"]")
	WebElement city  ;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_Address1\"]")
	WebElement addr1 ;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_Address2\"]")
	WebElement addr2 ;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_ZipPostalCode\"]")
	WebElement zipno ;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_PhoneNumber\"]")
	WebElement phoneno ;
	@FindBy(xpath="//*[@id=\"BillingNewAddress_FaxNumber\"]")
	WebElement faxno ;
	@FindBy(xpath="//*[@id=\"billing-buttons-container\"]/button[4]")
	WebElement continueBtn ;
	@FindBy(xpath="//*[@id=\"shippingoption_0\"]")
	WebElement Radio1;
	@FindBy(xpath="//*[@id=\"shippingoption_1\"]")
	WebElement Radio2;
	@FindBy(xpath="//*[@id=\"shippingoption_2\"]")
	WebElement Radio3;
	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/button")
	WebElement cBtn;
	@FindBy(xpath="//*[@id=\"paymentmethod_0\"]")
	WebElement checkRadioBtn;
	@FindBy(xpath="//*[@id=\"paymentmethod_1\"]")
	WebElement creditCardRadioBtn;
	@FindBy(xpath="//*[@id=\"payment-method-buttons-container\"]/button")
	WebElement cBtn1;
	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/button")
	WebElement cBtn2;
	@FindBy(xpath="//*[@id=\"confirm-order-buttons-container\"]/button")
	WebElement cBtn3;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]")
	WebElement FinalResult;
	public AddToCartPage(){
		//to conncet webelement with driver we are using pagefactory
	    PageFactory.initElements(driver,this);
	}
//
	//
	public void addProductToCart() throws InterruptedException {

		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(addtoCart)).click();
			//addtoCart.click();
			
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(addtoCart)).click();
		}
		Thread.sleep(2000);
	}

	public String getAddToCartResult() {
		
		return addToCartResult.getText();
	}
	
	
	public void removeProduct()throws InterruptedException {
		Utility.scrollUpByElement(driver);
		shoppingCartBtn.click();
		removeBtn.click();
	}
	
	public String getEmptyCartResult() {
		return emptyCartResult.getText();
	}
	
	public void setGiftWrapping(String term,String value) throws InterruptedException{
		Utility.scrollUpByElement(driver);
		//shoppingCartBtn.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCartBtn)).click();
		Utility.scrollDownByElement(driver,giftWrappingDropDown);
		giftWrappingDropDown.click();
		Utility.selectValue(giftWrappingDropDown, term, value);
		
	}
	
	public void setCCode(String a) throws InterruptedException {
		Utility.scrollUpByElement(driver);
		//shoppingCartBtn.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCartBtn)).click();
		Utility.scrollDownByElement(driver,couponCodeTB);
		couponCodeTB.sendKeys(a);
		couponCodeBtn.click();
		
	}
	public void setGiftCode(String b) {
		Utility.scrollDownByElement(driver,giftCodeTB);
		giftCodeTB.sendKeys(b);
		giftCodeBtn.click();
	}
	
	public String getCResult() {
		Utility.scrollDownByElement(driver,resultCouponCode);
		return resultCouponCode.getText();
	}
	
	public String getGResult() {
		Utility.scrollDownByElement(driver,resultGiftCode);
		return resultGiftCode.getText();
	}
	
	public void checkOut() {
		checkbox.click();
		checkoutBtn.click();
		Utility.scrollDownByElement(driver,checkoutAsGuestBtn);
		checkoutAsGuestBtn.click();
	}
	
	public void setShippingDetails(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l) throws InterruptedException {
		Utility.scrollDownByElement(driver,fname);
		fname.sendKeys(a);
		lname.sendKeys(b);
		email.sendKeys(c);
		company.sendKeys(d);
		Thread.sleep(2000);
		Contry("byValue",e);
		Thread.sleep(2000);
		State("byValue",f);
		Utility.scrollDownByElement(driver,city);
		city.sendKeys(g);
		addr1.sendKeys(h);
		addr2.sendKeys(i);
		zipno.sendKeys(j);
		phoneno.sendKeys(k);
		Utility.scrollDownByElement(driver,faxno);
		faxno.sendKeys(l);
		continueBtn.click();
		
	}
	
	public void Contry(String term,String value) {
		cDropDown.click();
		Utility.selectValue(cDropDown,term,value);
	}
	public void State(String term,String value) {
		sdropdown.click();
		Utility.selectValue(sdropdown,term,value);
	}
	
	public void SetShippingOptions(String a) {
		if(a.equals("Ground ($0.00)")) {
			Radio1.click();
		}
		else if(a.equals("Next Day Air ($0.00)")) {
			Radio2.click();
		}
		else {
			Radio3.click();
		}
		Utility.scrollDownByElement(driver,cBtn);
		cBtn.click();
	}
	
	public void SetPaymentOptions(String a) {
		Utility.scrollDownByElement(driver,checkRadioBtn);
		if(a.equals("Check / Money Order")) {
			checkRadioBtn.click();
		}
		
		else {
			creditCardRadioBtn.click();
		}
		Utility.scrollDownByElement(driver,cBtn1);
		cBtn1.click();
		Utility.scrollDownByElement(driver,cBtn2);
		cBtn2.click();
		Utility.scrollDownByElement(driver,cBtn3);
		cBtn3.click();
	}
	
	public String getFinalResult() {
		return FinalResult.getText();
	}
}
