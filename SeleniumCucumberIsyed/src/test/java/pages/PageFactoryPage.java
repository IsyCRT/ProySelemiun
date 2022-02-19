package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PageFactoryPage extends BasePage{

    public PageFactoryPage() {
        super(driver);
        driver.get("www.google.com");
        
    }
// un ejemplo: dentro del findBy ponemos el criterio de busqueda y luego creamos el WebElement listo para usarse
    @CacheLookup
    @FindBy(id = "boton")
    WebElement boton;
    
}
