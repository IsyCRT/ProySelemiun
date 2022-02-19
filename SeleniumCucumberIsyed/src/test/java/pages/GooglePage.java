package pages;
// la responsabilidad de esta clase es manejar la página. El test y sus validaciones deberia er en otra clase, en este caso en las steps definicion
public class GooglePage extends BasePage{

    private String searchButton = "//input[@value='Buscar con Google']";// solo sirve este locator en español, si cambia pa ingles puede q sea mejor xpath relativo
    private String searchTextField = "//input[@title='Buscar']";
    private String firstResult = ""; // el locator del elemento
    

    public GooglePage(){
        super(driver);
    }
    
    public void navegateToGoogle(){
         navigateTo("https://www.google.com");
    }
    
    public void clickGoogleSearch(){
        clickElement(searchButton);
   }
    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }

    public String fistResults(){
      return textFromElement(firstResult);
    }

  }
