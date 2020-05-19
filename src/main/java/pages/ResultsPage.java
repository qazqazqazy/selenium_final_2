package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class ResultsPage extends BasePage {

    //конструктор
    public ResultsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    public  ResultsPage (WebDriver driver) {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30, 4000);//ожидаем появления
        wait.until(ExpectedConditions.visibilityOf(firstElement));

    }
    //Найденные элементы
    @FindBy(xpath = "//h3//a[contains(text(),'Наушники')]")
    public WebElement resultString;

    //первый элемент
    @FindBy(xpath = "//h3//a[1][contains(text(),'наушники')]")
    public WebElement firstElement;


    //строка поиска
    @FindBy(id = "header-search")
    public WebElement searchFieldF;

    //заполнение поля
    public void fillField(String fieldName, String value){
        switch (fieldName) {
            case  "Строка поиска":
                fillField(searchFieldF, value);
                break;

            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    /*
    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Строка поиска":
                return searchFieldF.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }
     */
    //Кнопка Найти
    @FindBy(xpath = "//div[contains(text(),'Найти')]/..")
    public WebElement find;


}