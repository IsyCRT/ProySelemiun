package pages;

public class GridPage extends BasePage{
    private String cell = "//*[@id='root]/div";// devuelve la raiz de la tabla, la cual luego se concatena en la base page con la roll,col
    private String mainTable="//*[@id='root']/div/table";

    public GridPage() {
        super(driver);
    }

    public void navigateToGrid() {
        navigateTo("https://1v2njkypo4.csb.app");
    }
    
    public String getValueFromGrid(int row, int col) {
        return getValueFromTable(cell, row, col);
    }

    public void setValueOnGrid(int row, int col, String setValue) {
         setValueOnTable(cell, row, col, setValue);
    }
//existe la tabla?
    public boolean tableStatus(){
        return elementisDisplayed(mainTable);

    }
}
