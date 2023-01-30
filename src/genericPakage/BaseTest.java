package genericPakage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {
	protected static WebDriver driver;
	@BeforeMethod
	public void openBrowser() throws IOException
	{
		Flib flib = new Flib();

		 String browserValue = flib.readProertyData(PROP_PATH,"Browser");
		
		String url = flib.readProertyData(PROP_PATH,"Url");

		if(browserValue.equals("Chrome"))
		{
			System.setProperty(CHROME_KEY,CHROME_VALUE);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
		}


		else if(browserValue.equals("firefox"))
		{
			System.setProperty(GECKO_KEY,GECKO_VALUE);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
		}
		else
		{
			System.out.println("enter the valid browserValue!!!");
		}

	}
	public void closeBrowser()
	{
		driver.quit();
	}
}
