package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver;
	protected static Properties repository;

	public TestBase() 
	{
		try 
		{
			
		repository = new Properties();
		String srcFile = System.getProperty("user.dir") + "\\src\\main\\java\\Config\\config.properties";

		FileInputStream fis = new FileInputStream(srcFile);
		repository.load(fis);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void initializeBrowser()
	{
		String browser = repository.getProperty("browser");
		if(browser.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "C:/EclipseWorkspace/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver(options);
			
		}
		else if(browser.equals("firefox"))
		{
		
			System.setProperty("webdriver.gecko.driver", "C:/Eclipse Workspace/geckodriver-v0.21.0-win32/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(repository.getProperty("URL"));
		
	}
	
	
	public static boolean isElementClickable(WebElement element)      
	{
		try
		{
		   WebDriverWait wait = new WebDriverWait(driver, 5);
		   wait.until(ExpectedConditions.elementToBeClickable(element));
		   return true;
		}
		catch (Exception e)
		{
		  return false;
		}	
	}
	
	
}
