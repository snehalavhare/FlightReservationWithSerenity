package com.serenity.test.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import TestBase.TestBase;

public class SearchResultsPage extends TestBase
{

	WebDriver driver;
	
	String time;
	
	@FindBy(xpath = ".//ul[@class='listView flights']/li")
	List<WebElement> flightList;
	
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	public void bookFlight(String value)
	{
	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
        for(int i=1;i<flightList.size();i++) 
        {
               
           time= driver.findElement(By.xpath("//ul[@class='listView flights']/li["+(i)+"]/table/tbody[2]/tr[1]/th[2]")).getText();
           
           if(time.equals(value))
           {
        	   
               driver.findElement(By.xpath("//ul[@class='listView flights']/li["+(i)+"]/table/tbody[2]/tr[2]/td[3]/button")).click();
  
           }
		
       }
}
}
