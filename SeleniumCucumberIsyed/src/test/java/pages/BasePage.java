package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static{
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
        System.setProperty("webdriver.chrome.driver", "C:/Users/ASUS/Documents/SELENIUM");
    }

    public BasePage(WebDriver driver){
        BasePage.driver= driver;
        PageFactory.initElements(driver, this); // esto es para que las clases que heredan de BasePage, usando PageFactory tengan inicializado los WebElements
        wait= new WebDriverWait(driver, 10);
        //una espera implicita se puede hacer aqui, y se hace de manera global para todo el framework y es así:
     //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// esto espera 10 segundos entre cada paso, encontro un web eelement espera 10 egundo y busca el otro
        //me parece fatal
    }

    public static void  navigateTo (String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }


    private WebElement find (String locator){// Si el elemento lo ves prosigue, si no es vivible espera 10 segundos q fue lo fijado alla arriba 
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){  //funcion para dar click sobre un WebElement que econtré, click, clear, sendKeys son funciones que tiene un objeto webElement
        find(locator).click();
    }

    public void write( String locator, String textToWrite){ //funcion àra escribir sobre un webElement que previamente encontré
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }


    // Si el web Element no es un select puede que se aun div que dentro tenga div, ahi tendre que hacer un click y luego un segundo click
    //Select lo permite selenium
    public void selectFromDropDownByValue(String locator, String valueToSelect){ //valor es diferente a text
        Select dropdown = new Select(find(locator)); //select se crea pasandole un webelement que he encontrado
        dropdown.selectByValue(valueToSelect); // un select es un selector de opciones = listbox antiguamente
    }

    public void selectFromDropDownByIndex(String locator, Integer index){
        Select dropdown = new Select(find(locator)); //select se crea pasandole un webelement que he encontrado
        dropdown.selectByIndex(index);
    }

    public void selectFromDropDownByText(String locator, String text){
        Select dropdown = new Select(find(locator)); //select se crea pasandole un webelement que he encontrado
        dropdown.selectByVisibleText(text);
    }

    public void hoverOverElement(String locator){
        action.moveToElement(find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(find(locator));
    }

    public String getValueFromTable(String locator, int row, int col) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + col+ "]";
        return find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int col, String setValue) {
        String cellToField = locator + "/table/tbody/tr[" + row + "]/td[" + col+ "]";
        find(cellToField).sendKeys(setValue);;
    }
// en caso que el webElement sea de un element input de tipo file
    public void uploadFiles(String locator, String path){
        find(locator).sendKeys(path);

    }

    public void verTypeFile(){
        String change_visibility = "$(\"#fileField \").css(\"visibility,\"visible\");";
        String change_display = "$(\"#fileField \").css(\"display,\"block\");";
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript(change_display);
        js.executeScript(change_visibility);
        /* Posibles formas para encontrarlo con otros atributos
        ("#fileField").style.visibility="visible";
        ("#fileField").style.display="block";
        ("#fileField").style.width="200px";
        ("#fileField").style.height="200px";
        ("#fileField").style.position="fixed";
        ("#fileField").style.overflow="visible";
        ("#fileField").style.zIndex="999999";
        ("#fileField").style.top="500px";
        ("#fileField").style.bottom="500px";
        ("#fileField").style.left="500px";
        ("#fileField").style.right="500px";
        ("#fileField").style.marginBottom="100px";
        */
    }

   // iframe: elemento HTML que permite dentro de nuestra página web, ver contenido de otra página web.
    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex); //cambiar a otra pag
    }

    public void switchToParentFrame(){ //sino fuimos a un frame que esta dentro de la pagina pues volver al padre para seguir trabajando
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){// esta funcion quita la alaerta pa seguir haciendo acciones q si me interesa
       // driver.switchTo().alert().getText(); Me trae el texto de la alerta e caso que quiera comprobar su texto
       try {
        driver.switchTo().alert().dismiss();
       } catch (NoAlertPresentException e) {
           e.printStackTrace();
       }
     
    }

    /*Por buenas practicas no pondremos ninguna funcion de validacion en la BasePage*/
    public void validateText(String locator, String textToValidate){
        Assert.assertEquals(textToValidate, find(locator).getText());

    }
 
    //tengo que hacer bastantes try catch para recoger cosas como esta
    public String textFromElement(String locator){
        try {
            return find(locator).getText();
        } catch (Exception e) {
           return "Hasn't text";
        }
    } 

    public boolean elementEnabled(String locator){
        return find(locator).isEnabled(); // esta habilitado para usarse, por ejemplo un boton esta habilitado para clickearse
    }

    public boolean elementisDisplayed(String locator){
        return find(locator).isDisplayed(); // el element esta ahi
    }

    public boolean elementisSelected(String locator){
        return find(locator).isSelected(); // el element como radio button o check box esta seleccionado
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }
    
}
