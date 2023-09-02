package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.WebTestBase;
import utils.Utility;

public class WishlistPage extends WebTestBase {

	@FindBy(xpath="/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[3]")
	WebElement wishlistBtn;
	@FindBy(xpath="//*[@id=\"bar-notification\"]/div/p")
	WebElement wishListResult;
	@FindBy(xpath="/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a")
	WebElement WishlistBtn;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]/button")
	WebElement removeBtn;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div")
	WebElement resultOfEmptyList;
	public WishlistPage(){
		//to conncet webelement with driver we are using pagefactory
	    PageFactory.initElements(driver,this);
	}
	public void addToWishlist() {
		Utility.scrollDownByElement(driver,wishlistBtn);
		//wishlistBtn.click();
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(wishlistBtn)).click();
			//addtoCart.click();
			
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(wishlistBtn)).click();
		}
	}
	
	public String getWishlistResult() {
	return	wishListResult.getText();
	}
	
	public void RemoveItemFromWishlist() throws InterruptedException {
		Utility.scrollUpByElement(driver);
		WishlistBtn.click();
		removeBtn.click();
	}
	
	public String GetEmptyListResult() {
		return resultOfEmptyList.getText();
	}
}
