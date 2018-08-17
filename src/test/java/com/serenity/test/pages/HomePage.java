package com.serenity.test.pages;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestBase.TestBase;

public class HomePage extends TestBase
{

	String stringValue;
	public static String today;
	WebDriver driver;
	
	@FindBy(id="OneWay")
	private WebElement tripType;	
	
	@FindBy(id="FromTag")
	private WebElement fromCity;
	
	@FindBy(id="ToTag")
	private WebElement toCity;
	
	@FindBy(className = "icon ir datePicker")
	private WebElement departDate;
	
	@FindBy(id="Adults")
	private WebElement adults;
	
	@FindBy(id="Childrens")
	private WebElement childrens;
	
	@FindBy(id="id=Infants")
	private WebElement infants;
	
	@FindBy(id="SearchBtn")
	private WebElement searchButton;
	
	@FindBy(xpath="//h1[text()='Search flights']")
	private WebElement homeTitle;
	
	@FindBy(xpath="//a[@href='/flights']")
	private WebElement flightMenu;
	
	@FindBy(xpath = "//*[@class = 'autoComplete']/li/a")	
	private List<WebElement> fromCityList;
	
	@FindBy(xpath = "//*[@class = 'autoComplete'][2]/li/a")	
	private List<WebElement> toCityList;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	public void select_TripType(String value)
	{
		
		
		tripType.sendKeys(value);
		
	}
	
	public void enter_FromCity(String value)
	{
		String[] splitString = value.split(",");
		String searchValue = splitString[0];
		fromCity.sendKeys(searchValue);
		
		//List<WebElement> fromCityList = driver.findElements(By.xpath("//*[@class = 'autoComplete']/li/a"));
		
		//fromCityList.forEach((element) -> System.out.println("The list of to cities are:  "+element.getText()));
			
		fromCityList.stream().filter(p -> repository.getProperty("fromCity").equals(value))
							.findFirst().ifPresent(ele -> ele.click());						
		
	}
	
	public void enter_ToCity(String value)
	{
		String[] splitString = value.split(",");
		String searchValue = splitString[0];
		toCity.sendKeys(searchValue);
		
		//toCityList.forEach((element) -> System.out.println("The list of to cities are:  "+element.getText()));
		
		//List<WebElement> toCityList = driver.findElements(By.xpath("//*[@class = 'autoComplete'][2]/li/a"));
		
		toCityList.stream().filter(p -> repository.getProperty("toCity").equals(value))
		.findFirst().ifPresent(ele -> ele.click());	
		
		
	}
	
	
	public void enter_Adults(int value)
	{
		Select select = new Select(adults);
		stringValue = Integer.toString(value);
		select.selectByValue(stringValue);
			
	}
	
	public void enter_Childrens(int value)
	{
		Select select = new Select(childrens);
		stringValue = Integer.toString(value);
		select.selectByValue(stringValue);
		
	}
	
	public void enter_Infants(int value)
	{
		
		Select select = new Select(infants);
		stringValue = Integer.toString(value);
		select.selectByValue(stringValue);
	}
	
	public void click_SearchButton()
	{
		searchButton.click();
	}

	public String getHomeTitle()
	{
		String title =  homeTitle.getText();
		return title;
	}
	
	public void selectFlightMenu()
	{
		flightMenu.click();
	}
	
	public void enter_DepartDate(String value)
	{

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        today = getCurrentDay();

 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //This is from date picker table
        WebElement dateWidgetFrom = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody"));
 
        //This are the rows of the from date picker table
        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
 
        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
 
     
        for (WebElement cell: columns) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {
            */
            //Select Today's Date
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }
 

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

 

    private String getCurrentDay (){
     
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
 
   
        String todayStr = Integer.toString(todayInt);
       
        return todayStr;
    }			
	}
	

	
