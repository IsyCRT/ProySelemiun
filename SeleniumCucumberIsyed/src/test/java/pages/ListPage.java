package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {
    private String searchField="//body/form[1]/input[1]";
    private String searchResults="name";// sera el name del recurso webElement que contiene la lista???
   
    public ListPage() {
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }

    public void enterSearchCriteria(String state) throws InterruptedException{
        try {
            Thread.sleep(600);
            write(searchField, state);
        } catch (NoSuchElementException e) {
            System.out.println("The webElement Search Field could not be found.");
            e.printStackTrace();
        }
      
    }

    public List<String> getAllSearchResults(){
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringFromList = new ArrayList<String>();
        for (WebElement e :list)
            stringFromList.add(e.getText());
        return stringFromList;
    }
    
}
