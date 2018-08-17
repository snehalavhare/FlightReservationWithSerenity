package com.serenity.test.steps.serenity;


import org.junit.Assert;

import com.serenity.test.pages.HomePage;
import com.serenity.test.pages.ReviewDetailsPage;
import com.serenity.test.pages.SearchResultsPage;

import TestBase.TestBase;
import net.thucydides.core.annotations.Step;


public class EndUserSteps extends TestBase
{

	
	//TestBase base;
	
	@Step
	public void openHomePage()
	{
		//base = new TestBase();
		TestBase.initializeBrowser();			
	}
	
	@Step
	public void enterFlightDetails()
	{
	HomePage homePage = new HomePage(driver);
	//page.selectFlightMenu();
	Assert.assertTrue(homePage.getHomeTitle().contains("Search flights"));
	homePage.select_TripType(repository.getProperty("tripType"));
	homePage.enter_FromCity(repository.getProperty("fromCity"));
	homePage.enter_ToCity(repository.getProperty("toCity"));
	homePage.enter_DepartDate(repository.getProperty("departDate"));
	homePage.enter_Adults(1);
	homePage.enter_Adults(1);
	homePage.click_SearchButton();
	
	}
	
	
	@Step
	public void selectFlight()
	{
		
		SearchResultsPage Listpage = new SearchResultsPage(driver);
		Listpage.bookFlight(repository.getProperty("flightTime"));
	}
	
	
	@Step
	public void enterTravellerDeyails() throws InterruptedException
	{
		
		ReviewDetailsPage reviewDetailsPage = new ReviewDetailsPage(driver);
		Assert.assertTrue(reviewDetailsPage.check_Itinerary());
		reviewDetailsPage.addBaggage(repository.getProperty("baggage"));			
		reviewDetailsPage.addMeals(repository.getProperty("mealType"));
		reviewDetailsPage.selectSeat();
		reviewDetailsPage.Enable_Insurance(repository.getProperty("insurance"));
		reviewDetailsPage.acceptTC_ContinueBooking();
	}
	
	
	
}

