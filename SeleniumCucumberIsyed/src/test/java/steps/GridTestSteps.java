package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.GridPage;

public class GridTestSteps {
    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage() throws InterruptedException{
    //    Thread.sleep(2000); // mala práctica
        grid.navigateToGrid();

    }

    @Then("^I can return the value I wanted$")
    public void returnValue(){
       final String value= grid.getValueFromGrid(3, 2);
       Assert.assertEquals("1 a", value);
    }
    
    
    @And("^I can update the value I wanted$")
    public void setValue(){
        grid.setValueOnGrid(3, 2, "Valor");
    }


    @Then("^I can validate the table is displayed$")
    public void theTablesIsThere(){
       Assert.assertTrue("El elem no esta siendo mostrado", grid.tableStatus());
       //si es assertFalse me interesa q sea falso
    }

}

