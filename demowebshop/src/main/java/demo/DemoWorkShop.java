package demo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import genericutility.Propertiesclass;

public class DemoWorkShop {
	public WebDriver driver;
	@BeforeClass
	public void openBrowser()
	{
		String browser = System.getProperty("browser");
		if(browser.contains("Chrome"))
		{
	//	driver=new ChromeDriver();
		}
		else if(browser.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		Propertiesclass fetch0=new Propertiesclass();
		String url = fetch0.fetchProperties("Url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@BeforeMethod
	public void login()
	{
		Propertiesclass fetch1=new Propertiesclass();
		String Username = fetch1.fetchProperties("Username");
		String Password = fetch1.fetchProperties("Password");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		String title = driver.getTitle();
		Assert.assertEquals(title.contains("Loggn"), true);
		Reporter.log("Login page Display", true);
		//driver.findElement(By.id("Email")).sendKeys(Username);
		//driver.findElement(By.id("Password")).sendKeys(Password);
		//driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	@AfterMethod
	public void refersh()
	{
		driver.navigate().refresh();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

	

}
