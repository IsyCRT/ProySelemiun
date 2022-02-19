package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GooglePage;

//Los stepd definition son mas para las validaciones que quiero hacer
public class GoogleSteps {

  GooglePage googlePage = new GooglePage();
 
  @Given("^I am on the Google search page$")  
  public void navigateToGoogle(){
    googlePage.navegateToGoogle();
    
  } 

  @When("^I enter a search criteria$")  
  public void enterSearchCriteria(){
    googlePage.enterSearchCriteria("Argentina");
  }

  @And("^Click on the search button$")  
  public void clickSearchButton(){
    googlePage.clickGoogleSearch();

  }

  @Then("^The results match the criteria$")  
  public void validarResults(){
   Assert.assertEquals("text expected", googlePage.fistResults());   
  }
} 



