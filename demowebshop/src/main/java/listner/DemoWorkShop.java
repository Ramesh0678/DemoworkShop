package listner;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import genericutility.Propertiesclass;

public class DemoWorkShop {
	public  static WebDriver driver;
	@BeforeClass
	public void openBrowser()
	{
		driver=new ChromeDriver();
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
		driver.findElement(By.id("Email")).sendKeys(Username);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.xpath("//a[text()='rameshr123@gmail.com']")).click();
		driver.findElement(By.xpath("//div[@class='block block-account-navigation']//following-sibling::ul//li[2]/a")).click();
		driver.findElement(By.xpath("//input[@class='button-1 add-address-button']")).click();
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
