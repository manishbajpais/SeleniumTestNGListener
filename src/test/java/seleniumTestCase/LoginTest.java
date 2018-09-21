package seleniumTestCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import seleniumQAbase.BaseClass;
import seleniumtestNGlistener.CustomListener;

@Listeners(CustomListener.class)
public class LoginTest extends BaseClass{
	
	@BeforeMethod
	public void setUp() {
		initialization();
	}
	
	@AfterMethod
	public void teatDown() {
		driver.quit();
	}
	
	@Test
	public void LoginTest() {
		driver.findElement(By.name("username")).sendKeys("manish123");
		driver.findElement(By.name("password")).sendKeys("manish123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@Test(dependsOnMethods="LoginTest", groups="smoke")
	public void validatetitleTesth() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "\"#1 Free CRM software in the cloud for sales and service");
		
	}
	
	
	
	@AfterMethod
	public void logOut() {
		driver.findElement(By.name("Logout")).click();
	}
	
	

}
