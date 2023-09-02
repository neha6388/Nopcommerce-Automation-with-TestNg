package testCase;


import pages.AddToCartPage;
import pages.HomePage;

import pages.LoginPage;
import pages.RegistrationPage;
import pages.WishlistPage;
import testBase.WebTestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.*;


public class TC01 extends WebTestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	RegistrationPage registrationPage;
	AddToCartPage addtocartpage;
	WishlistPage wishlistpage;
	//loading the config file
		public TC01() {
			super();
		}
		
		
		@BeforeMethod
		public void BeforeMethod() {
			initialization();
			
			homePage=new HomePage();
			loginPage=new LoginPage();
			registrationPage=new RegistrationPage();
			addtocartpage=new AddToCartPage();
			wishlistpage=new WishlistPage();
		}
	//Login and Registration Testcases 2
		
	@Test(priority=1)
		public void verifyRegistration() {
		SoftAssert softAssert = new SoftAssert();
			registrationPage.verifyRegistration(1,"abc","abc","9","9","1999","abcd@gmail.co","abc","1234567890","1234567890");
			softAssert.assertEquals(registrationPage.getRStatus(),"Your registration completed","Registration unseccesful." );
			softAssert.assertAll();	
	}
		
	@Test(priority=2)
		public void checkLogin()  {
		 SoftAssert softAssert = new SoftAssert();
			loginPage.login(prop.getProperty("un"), prop.getProperty("password"));
			   softAssert.assertAll();
			 
	}

//	//Basic testcase 7
	
	
		@Test(priority=3)
		public void verifyGetWindowhandle() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
		     homePage.verifyGetWindowhandle();
		     softAssert.assertAll();
		}
		
		@Test(priority=4)
		public void verifyFooter() {
			SoftAssert softAssert = new SoftAssert();
			String actualResult=homePage.getFooter();
			String expectedResult="Copyright © 2023 nopCommerce demo store. All rights reserved.";
			System.out.println(actualResult);
			System.out.println(expectedResult);
			softAssert.assertEquals(actualResult,expectedResult,"Match not found." );
			 softAssert.assertAll();
		}
		
		
		
		@Test(priority=5)
		public void checkScrolling() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			 homePage.scrollUpDown();
			  softAssert.assertAll();
		}
		
		
		@Test(priority=6)
		public void chcekSearchAndFilter() throws InterruptedException {
			SoftAssert softassert=new SoftAssert();
			homePage.search("jewelry");
			//softassert.assertEquals(homePage.getSearchResult(), "jewelry","Match not found.");
			homePage.selectDropDown("byIndex", "1");
			softassert.assertAll();
		}
		
//		@Test(priority=7)
//		public void checkReviewBtn() {
//		SoftAssert softassert=new SoftAssert();
//			homePage.checkReviewRadio("Excellent");
//			 softassert.assertAll();
//		}
//		
//		@Test(priority=8)
//		public void verifySlider() {
//		SoftAssert softassert=new SoftAssert();
//			homePage.checkSlider();
//			 softassert.assertAll();
//		}
//		
//		
//		
//		
//		@Test(priority=9)
//		public void checkLogout() {
//			SoftAssert softAssert = new SoftAssert();
//			 homePage.verifyLogout();;
//			  softAssert.assertAll();
//		}
	//Wishlist testcases 2
	
//		@Test(priority=10,enabled=false)
//		public void checkAddingProductToWishlist() throws InterruptedException {
//		SoftAssert softassert=new SoftAssert();
//		homePage.search("jewelry");
//		homePage.selectDropDown("byIndex", "1");
//			wishlistpage.addToWishlist();
//			softassert.assertEquals(wishlistpage.getWishlistResult(), "The product has been added to your wishlist","Match not found.");
//			 softassert.assertAll();
//		}
//		
//		@Test(priority=11)
//		public void RemoverProductFromWishlist() throws InterruptedException {
//			SoftAssert softassert=new SoftAssert();
//			homePage.search("jewelry");
//			homePage.selectDropDown("byIndex", "1");
//				wishlistpage.addToWishlist();
//				softassert.assertEquals(wishlistpage.getWishlistResult(), "The product has been added to your wishlist","Match not found.");
//				Thread.sleep(500);
//				wishlistpage.RemoveItemFromWishlist();
//				softassert.assertEquals(wishlistpage.GetEmptyListResult(),"The wishlist is empty!","Match Not Found");
//				softassert.assertAll();
//		}
		
	//Cart Testcases 3
		
//		@Test(priority=12)
//		public void checkAddingProductToCart() throws InterruptedException {
//			SoftAssert softassert=new SoftAssert();
//			Thread.sleep(1000);
//			homePage.search("jewelry");
//			homePage.selectDropDown("byIndex", "1");
//			addtocartpage.addProductToCart();
//			softassert.assertEquals(addtocartpage.getAddToCartResult(), "The product has been added to your shopping cart","Match No Found.");
//			softassert.assertAll();
//		}
//		
//		@Test(priority=13)
//		public void CheckRemovingOfProductFromCart()throws InterruptedException {
//			SoftAssert softassert=new SoftAssert();
//		homePage.search("jewelry");
//		homePage.selectDropDown("byIndex", "1");
//		addtocartpage.addProductToCart();
//			softassert.assertEquals(addtocartpage.getAddToCartResult(), "The product has been added to your shopping cart","Match No Found.");
//		addtocartpage.removeProduct();
//		softassert.assertEquals(addtocartpage.getEmptyCartResult(), "Your Shopping Cart is empty!","Match No Found.");
//			softassert.assertAll();
//	}
//	
//		@Test(priority=14)
//		public void CheckOut()throws InterruptedException {
//			SoftAssert softassert=new SoftAssert();
//			homePage.search("jewelry");
//			homePage.selectDropDown("byIndex", "1");
//			addtocartpage.addProductToCart();
//			softassert.assertEquals(addtocartpage.getAddToCartResult(), "The product has been added to your shopping cart","Match No Found.");
//			Thread.sleep(500);
//			addtocartpage.setGiftWrapping("byValue","1");
//			addtocartpage.checkOut();
//			addtocartpage.setShippingDetails("abc", "abc", "abc@gmail.com", "abcde", "133","0", "Mumbai", "Panvel", "Navi Mumbai", "410206", "123456", "1234567890");
//			addtocartpage.SetShippingOptions("2nd Day Air ($0.00)");
//			addtocartpage.SetPaymentOptions("Check / Money Order");
//			softassert.assertEquals(addtocartpage.getFinalResult(), "Your order has been successfully processed!","Match No Found.");
//			softassert.assertAll();
//		}
		
	@AfterMethod
		public void AfterMethod() {
			driver.close();
		}
}
