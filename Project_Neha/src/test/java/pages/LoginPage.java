package pages;
import testBase.WebTestBase;
import utils.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WebTestBase {
	@FindBy(xpath="/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement login;
	@FindBy(xpath="//*[@id=\"Email\"]")
	WebElement usernameField;
	@FindBy(xpath="//*[@id=\"Password\"]")
	WebElement passwordField;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
	WebElement loginBtn;
	public LoginPage(){
		  PageFactory.initElements(driver,this);
	}
	
	public  void login(String username, String password) {
		login.click();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}

}
