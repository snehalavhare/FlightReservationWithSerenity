package com.serenity.test.stepDefinition;

import com.serenity.test.steps.serenity.EndUserSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class stepDefinition 
{
	
	@Steps
	EndUserSteps endsteps;
	
	@Given("User is on Home Page and selects Flights Menu")
	public void User_is_on_Home_Page()
	{
		endsteps.openHomePage();
	}
	
	
	@When("User selects Flights Enters data and search")
	public void User_selects_Flights_Enters_data_and_search()
	{
		endsteps.enterFlightDetails();
	}
	
	
	@Then("Matching flights should be displayed")
	public void Matching_flights_should_be_displaye()
	{
		endsteps.selectFlight();
	}
	
	@And("User should be able to add Flight Details")
	public void User_should_be_able_to_add_Flight_Details() throws InterruptedException
	{
		endsteps.enterTravellerDeyails();
	}
}
