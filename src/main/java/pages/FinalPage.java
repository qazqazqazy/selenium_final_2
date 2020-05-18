package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class FinalPage {

    //конструктор
    public FinalPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public FinalPage(WebDriver driver) {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30, 4000);//ожидаем появления
       wait.until(ExpectedConditions.visibilityOf(searchFieldFT));
    }

    //первый элемент
    //@FindBy(xpath = "//h3//a[contains(text(),'Телевизор')][1]")
    @FindBy(xpath = "//h3//a[contains(@title,'Телевизор')]")
    public WebElement firstElement;

    //строка поиска
    @FindBy(xpath = "//div/input[contains(@id, 'header-search')]")
    public WebElement searchFieldFT;

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Строка поиска":
                return searchFieldFT.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

}