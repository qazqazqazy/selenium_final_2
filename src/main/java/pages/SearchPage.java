package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class SearchPage extends BasePage {

    //конструктор
    public SearchPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public  SearchPage (WebDriver driver) {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 10, 4000);//ожидаем появления
        wait.until(ExpectedConditions.visibilityOf(next));
    }

    //элемент для ввода стартовой суммы
    @FindBy(id = "glf-pricefrom-var")
    public WebElement startPrice;


    //флажок Beats
    @FindBy(xpath = "//LABEL[@class='checkbox__label'][text()='Beats']")
    public WebElement prodBeats;

    //Показать подходящие
    @FindBy(xpath = "//A[@role='button'][2]")
    public WebElement next;

    //заполнение поля
    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Цена от":
                fillField(startPrice, value);
                break;

            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }


}
