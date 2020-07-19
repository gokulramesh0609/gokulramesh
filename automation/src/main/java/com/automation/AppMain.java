package com.automation;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AppMain {

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.out.println("press 1 to signin");
		System.out.println("press 2 to signup");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		System.setProperty("webdriver.chrome.driver","E:\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.com/");
		
		String title=driver.getTitle();
		driver.findElement(By.name("q")).sendKeys("automation practice");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.partialLinkText("Automation Practice")).click();
		driver.findElement(By.className("header_user_info")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		switch(option)
		{
		case 1:
		driver.findElement(By.cssSelector("input#email_create")).sendKeys("gop459568al@gmail.com");
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
		break;
		
		
		case 2:
				driver.findElement(By.id("email")).sendKeys("gocool@gmail.com");
				driver.findElement(By.id("passwd")).sendKeys("12345");
				driver.findElement(By.id("SubmitLogin")).click();
				break;
		
	}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("T-SHIRTS")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Add to cart")).click();
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
		Thread.sleep(5000);
		driver.close();
	}

	

	
}
