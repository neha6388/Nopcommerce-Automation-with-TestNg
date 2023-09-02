package utils;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	public static void scrollDownByElement(WebDriver driver, WebElement element) {
		// TODO Auto-generated method stub
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element );
	}
	public static void scrollUpByElement(WebDriver driver)throws InterruptedException {
		// TODO Auto-generated method stub
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(3000);
//		JavascriptExecutor j=(JavascriptExecutor)driver;
//		//j.executeScript("window.scrollBy(0,500)");
//		
//		for(int i=0;i<10;i++) 
//		{
//			j.executeScript("window.scrollBy(0,-500)");
//			
//		}
		
	}

	public static void switchToWindows(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		String parentWindow=driver.getWindowHandle();
		Set<String> allwindow=driver.getWindowHandles();
		for(String s : allwindow) {
			if(!parentWindow.contentEquals(s)) {
				driver.switchTo().window(s);
				Thread.sleep(5000);
				driver.close();
			}
			
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);		
	}
	
	public static void scrollPage(WebDriver driver) throws InterruptedException {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500)");
		
		for(int i=0;i<10;i++) 
		{
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		}
		
		for(int i=0;i<10;i++) 
		{
			j.executeScript("window.scrollBy(0,-500)");
			Thread.sleep(1000);
		}
	}
	
	public static void selectValue(WebElement element, String term, String value) {
		// TODO Auto-generated method stub
		Select dropDown=new Select(element);
		if(term.equalsIgnoreCase("byValue")){
            dropDown.selectByValue(value);
        }else if(term.equalsIgnoreCase("byIndex")){
            dropDown.selectByIndex(Integer.parseInt(value));
        }else if(term.equalsIgnoreCase("byVisibleText")){
            dropDown.selectByVisibleText(value);
        }else{
            System.out.println("Please select the correct value");
        }
	}

	
}
