package com.qa.auto.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Test1 {
	 public WebDriver driver;
  
	@Test
  public void A() throws InterruptedException
	{
		
		  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		  driver.findElement(By.linkText("WOMEN")).click();
		
		  
		driver.findElement(By.xpath("//img[contains(@alt,'Faded Short Sleeve T-shirts')]")).click();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
		
		Thread.sleep(3000);
		String text = driver.findElement(By.id("layer_cart_product_title")).getText();
		System.out.println(text);
		
		String text1 = driver.findElement(By.id("layer_cart_product_attributes")).getText();
		System.out.println(text1);
		
		String text2= driver.findElement(By.className("dark")).getText();
		System.out.println(text2);
		
		String text3= driver.findElement(By.id("layer_cart_product_quantity")).getText();
		System.out.println(text3);
		
		String text4=driver.findElement(By.id("layer_cart_product_price")).getText();
		System.out.println(text4);
		
	 WebElement ele = driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", ele);
	
	
        String Expected = "Product successfully added to your shopping cart";		
        WebElement Actual = driver.findElement(By.xpath("//div[@id='layer_cart']/div/div/h2"));
	   //div[contains(@class, 'layer_cart_product')]//h2
	   System.out.println(Actual.getAttribute("innerText").trim());
      
		
		
		
	}
	
 
	@BeforeMethod
  public void beforeMethod() throws InterruptedException 
	{

		System.setProperty("webdriver.gecko.driver", "C:\\seltech\\exe\\geckodriver.exe");
			 driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://Automationpractice.com");
			Thread.sleep(200);
			driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jetblue@grr.la");
			driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("jetblue");
			driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
			
			
  }

  
	@AfterMethod
  public void afterMethod() 
	{
		driver.close();
		
  }

}
