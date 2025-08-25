package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups= {"sanity","regression","functional","master"})
	@Parameters({"browser","os"})
	public void setup(String br, String os) throws Exception 
	{
		p = new Properties();
		FileInputStream file = new FileInputStream("./src//test//resources/config.properties");
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			switch(os.toLowerCase())
			{
			case "windows": capabilities.setPlatform(Platform.WINDOWS); break ; 
			case "mac" : capabilities.setPlatform(Platform.MAC); break ;
			case "linux": capabilities.setPlatform(Platform.LINUX); break ;
			default : System.out.println("No Matching OS found..."); return ;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break ;
			case "firefox" : capabilities.setBrowserName("firefox"); break;
			default : System.out.println("No Matching Browser found..."); break;
			
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome" : driver = new ChromeDriver(); break ;
			case "firefox" : driver = new FirefoxDriver(); break ;
			default : System.out.println("No Matching Browser found..."); return;
			}
		}
		
		
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass(groups= {"sanity","regression","functional","master"})
	public void teardown() 
	{
		driver.quit();
	}

	public String getTitle()
	{
		return (driver.getTitle());
	}
	
	public String getCurrentUrl()
	{
		return (driver.getCurrentUrl());
	}
	
	public String getwindowhandles(int num)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(windowHandles);
		
		for(int j=0;j<=l.size();j++)
		{
			String val = l.get(num);
			return val;
		}
		
		return null;
		
		
	}
	
	public void getchildwindow(String child)
	{
		driver.switchTo().window(child);
	}
	
	public String captureScreen(String name)
	{
		String timestamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:SS").format(new Date());
		
		TakesScreenshot tks = (TakesScreenshot) driver;
		File src = tks.getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir")+"\\screenshots\\" + name + " _ " + timestamp + ".png";
		File trg = new File(filepath);
		src.renameTo(trg);
		
		return filepath;
	}
	
	
	
	
	
	
}
