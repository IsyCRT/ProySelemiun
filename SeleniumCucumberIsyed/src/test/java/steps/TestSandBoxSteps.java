package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.TestSandBox;

public class TestSandBoxSteps {
    TestSandBox sandBoxPage = new TestSandBox();

    @Given ("^I navigate to the sandbox page$")
    public void navigateToSandboxSite(){
        sandBoxPage.navigateToSandBox();
    }
    
    @And ("^Select a value from the dropdown$")
    public void SelectSate(){
        sandBoxPage.selectCategory("Manual");
    }
}

