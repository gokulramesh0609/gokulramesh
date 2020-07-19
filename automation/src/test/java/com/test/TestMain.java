package com.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMain 
{
 
	public WebDriver driver=new ChromeDriver();
	
	
	@BeforeClass
	public void setUp()
	{
		driver.get("https://www.google.com/");
		String title=driver.getTitle();
		driver.findElement(By.name("q")).sendKeys("automation practice");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.partialLinkText("Automation Practice")).click();
		driver.findElement(By.className("header_user_info")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test(enabled = false)
	public void forSignUp()
	{driver.findElement(By.cssSelector("input#email_create")).sendKeys("gocool@gmail.com");
	driver.findElement(By.cssSelector("button#SubmitCreate")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("id_gender1")).click();
	driver.findElement(By.id("customer_firstname")).sendKeys("gokul");
	driver.findElement(By.id("customer_lastname")).sendKeys("ramesh");
	driver.findElement(By.id("passwd")).sendKeys("12345");
	Select dropday=new Select(driver.findElement(By.id("days")));
	dropday.selectByIndex(6);
	Select dropmonth=new Select(driver.findElement(By.id("months")));
	dropmonth.selectByValue("9");
	Select dropyear=new Select(driver.findElement(By.id("years")));
	dropyear.selectByValue("1998");
	driver.findElement(By.id("company")).sendKeys("BNP PARIBAS");
	driver.findElement(By.id("address1")).sendKeys("ram nagar,trichy");
	driver.findElement(By.id("city")).sendKeys("Trichy");
	Select dropstate=new Select(driver.findElement(By.id("id_state")));
	dropstate.selectByValue("14");
	driver.findElement(By.id("postcode")).sendKeys("63913");
	Select dropcountry=new Select(driver.findElement(By.id("id_country")));
	dropcountry.selectByValue("21");
	driver.findElement(By.id("phone_mobile")).sendKeys("9790326798");
	driver.findElement(By.id("alias")).sendKeys("Trichy");
	driver.findElement(By.id("submitAccount")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	@Test(priority = 1)
	@Parameters({"email","password"})
	public void forSignIn(String email,String password)
	{
		
		
		if(email.equals("gocool@gmail.com") && password.equals("12345"))
		{
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		}
		else
		{
			System.out.println("invalid user name or password");
		}

		Assert.assertEquals(email,"gocool@gmail.com");
		Assert.assertEquals(password,"12345");
	
	}
	
	
	@Test(priority = 2)
	public void forSelectCategory()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("T-SHIRTS")).click();
	}
	
	
	@Test(priority = 3)
	public void forSelectCloth()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Add to cart")).click();
	}
	
	@Test(priority =4)
	public void forPayment()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Proceed to checkout")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Proceed to checkout")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(By.name("processAddress")).click();			
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.name("processCarrier")).click();
		driver.findElement(By.partialLinkText("Pay by bank wire")).click();
		driver.findElement(By.xpath("//*[@class='button btn btn-default button-medium']")).click();
	}
	
	@Test(priority = 5)
	public void forCloseDriver() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
	
	
	
	
	

	
}
