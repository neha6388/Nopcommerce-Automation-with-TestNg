package pages;
import testBase.WebTestBase;

import utils.Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage  extends WebTestBase{
	@FindBy(xpath="//html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
WebElement registerBtn;
	@FindBy(xpath="//*[@id=\"gender-male\"]")
	WebElement maleRadioBtn;
	@FindBy(xpath="//*[@id=\"gender-female\"]")
WebElement femaleRadioBtn;
	@FindBy(xpath="//*[@id=\"FirstName\"]")
	WebElement fname;
	@FindBy(xpath="//*[@id=\"LastName\"]")
	WebElement lname ;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]")
	WebElement  day;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]")
	WebElement  month;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]")
	WebElement  year;
	@FindBy(xpath="//*[@id=\"Email\"]")
	WebElement  emaill;
	@FindBy(xpath="//*[@id=\"Company\"]")
	WebElement cname ;
	@FindBy(xpath="//*[@id=\"Newsletter\"]")
	WebElement  newslettercheckbox;
	@FindBy(xpath="//*[@id=\"Password\"]")
	WebElement pwdd ;
	@FindBy(xpath="//*[@id=\"ConfirmPassword\"]")
	WebElement  cpwdd;
	@FindBy(xpath="//*[@id=\"register-button\"]")
	WebElement registerBtnn ;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")
	WebElement registrationStatus ;
	
	
	public RegistrationPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void verifyRegistration(int a,String fn,String ln,String d,String m,String y,String email,String company,String pwd,String cPWD) {
	registerBtn.click();	
	if(a==1) {
		maleRadioBtn.click();
	}
	else {
		femaleRadioBtn.click();
	}
	fname.sendKeys(fn);
	lname.sendKeys(ln);
	Day("byValue",d);
	Month("byValue",m);
	Year("byValue",y);
	emaill.sendKeys(email);
	cname.sendKeys(company);
	newslettercheckbox.click();
	pwdd.sendKeys(pwd);
	cpwdd.sendKeys(cPWD);
	registerBtnn.click();
	
	}
	
	public void Day(String term,String value) {
		day.click();
		Utility.selectValue(day,term,value);
	}
	public void Month(String term,String value) {
		month.click();
		Utility.selectValue(month,term,value);
	}
	public void Year(String term,String value) {
		year.click();
		Utility.selectValue(year,term,value);
	}
	
	public String getRStatus() {
		return registrationStatus.getText();
	}
	
}
