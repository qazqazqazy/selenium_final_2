package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class SecondPage {


    //МЕНЮ на второй странице (Электроника)
    @FindBy(xpath="//div[@role='tablist']//div//a//span[contains(text(),'Электроника')]")
    public WebElement subMenu;

    //находим раздел Телевизоры
    //@FindBy (xpath="//a[contains(text(),'Телевизоры')]")
    //public WebElement television;

    //находим раздел Наушники
    @FindBy (xpath="//a[contains(text(),'Наушники')]")
    public WebElement earPh;


    //поиск кнопки "Все фильтры"
    @FindBy (xpath="//span[contains(text(),'Все фильтры')]")
    public WebElement sendButtonFilters;


    public  SecondPage (WebDriver driver) {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30, 4000);//ожидаем появления
        wait.until(ExpectedConditions.visibilityOf(subMenu));


    }



}
