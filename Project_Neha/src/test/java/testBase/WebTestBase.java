package testBase;
import java.time.Duration;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
public class WebTestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public WebTestBase()
	{
		try
		{
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//properties//config.properties");
			prop = new Properties();
			prop.load(fileInputStream);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void initialization()
	 {
        String browserName = prop.getProperty("browser");
        
        
        if (browserName.equals("chrome")){
        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neha\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        	driver = new ChromeDriver();
    	    driver.navigate().to(prop.getProperty("url"));
           driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
          driver.manage().deleteAllCookies();
        }
        else {
        	System.setProperty("webdriver.edge.driver", "C:\\Users\\Neha\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        	driver = new EdgeDriver();
    	    driver.get(prop.getProperty("url"));
           driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
          driver.manage().deleteAllCookies();
        }
}
}
