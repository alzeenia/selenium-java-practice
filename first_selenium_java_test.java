package com.selenium.java.first.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.*;

public class first_selenium_java_test
{
	public static WebDriver browser = null;
	String url;
	
	public static void main(String[] args) throws InterruptedException
	{
		String url="https://www.google.com";
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	
		//launch the browser
		browser.manage().window().maximize();
		browser.navigate().to(url);
		String pagetitle = browser.getTitle();
		
		//if(containsIgnoreCase(pagetitle,"google"))
		
		if(pagetitle.contains("Google"))
		{
			System.out.println("Passed: Title Matches");
		}
		else
		{
			System.out.println("Failed: Title does not matches. The title is: "+pagetitle);
		}
		
		browser.findElement(By.name("q")).sendKeys("alzeenia");
		browser.findElement(By.xpath("//*[contains(@class,\"FPdoLc\")]//*[@name=\"btnK\"][@type=\"submit\"]")).click();
	}
}