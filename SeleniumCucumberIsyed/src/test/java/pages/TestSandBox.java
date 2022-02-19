package pages;

public class TestSandBox extends BasePage{

    private String categoryDropDown = "//Select[@id='testingDropdown']" ;

    public TestSandBox() {
        super(driver);
    }

    public void navigateToSandBox() {
        navigateTo("http://www.testandquiz.com/selenium/testing.html");
    }

    public void selectCategory(String category) {
        selectFromDropDownByValue(categoryDropDown, category);
    }

    
}
