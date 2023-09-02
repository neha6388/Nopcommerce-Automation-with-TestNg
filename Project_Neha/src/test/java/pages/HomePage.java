package pages;
import testBase.WebTestBase;

import utils.Utility;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends WebTestBase{

@FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[4]/a")
WebElement youTubeOption;
@FindBy(xpath="/html/body/div[6]/div[4]/div[2]/div[1]/span")
WebElement footer1;
@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[1]")
WebElement slider1;
@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[2]")
WebElement slider2;
@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
WebElement logoutBtn;
@FindBy(xpath="//*[@id=\"small-searchterms\"]")
WebElement searchBox;
@FindBy(xpath="//*[@id=\"small-search-box-form\"]/button")
WebElement searchBtn;
@FindBy(xpath="//*[@id=\"products-orderby\"]")
WebElement sortBy;
@FindBy(xpath="//*[@id=\"q\"]")
WebElement searchResult;
@FindBy(xpath="//*[@id=\"pollanswers-1\"]")
WebElement Radio1;
//
@FindBy(xpath="//*[@id=\"pollanswers-2\"]")
WebElement Radio2;
@FindBy(xpath="//*[@id=\"pollanswers-3\"]")
WebElement Radio3;
@FindBy(xpath="//*[@id=\"pollanswers-4\"]")
WebElement Radio4;
@FindBy(xpath="//*[@id=\"vote-poll-1\"]")
WebElement voteBtn;
@FindBy(xpath="//*[@id=\"block-poll-vote-error-1\"]")
WebElement voteResult;
public HomePage(){
	//to conncet webelement with driver we are using pagefactory
    PageFactory.initElements(driver,this);
}




public void verifyGetWindowhandle() throws InterruptedException {
	
	Utility.scrollDownByElement(driver,youTubeOption);
	youTubeOption.sendKeys(Keys.ENTER);
	Utility.switchToWindows(driver);
}

public String getFooter() {
	return footer1.getText();
}

public void scrollUpDown() throws InterruptedException {
	
	Utility.scrollPage(driver);
}

public void verifyLogout() {
	logoutBtn.click();
}

public void search(String s) {
	searchBox.sendKeys(s);
	searchBtn.click();
}

public String getSearchResult() {
	
	return searchResult.getText();
}

public void selectDropDown(String term,String value) throws InterruptedException {
	sortBy.click();
	Utility.selectValue(sortBy,term,value);
	
}

public void checkReviewRadio(String a) {
	Utility.scrollDownByElement( driver,Radio1);
	if(a.equals("Excellent")) {
		Radio1.click();
	}
	else if(a.equals("Good")) {
		Radio2.click();
	}
	else if(a.equals("Poor")) {
		Radio3.click();
	}
	else {
		Radio4.click();
	}
	voteBtn.click();
}

public String getVoteResult() {
	return voteResult.getText();
}
public void checkSlider() {
	slider1.click();
	slider2.click();
}


}
