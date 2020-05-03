package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage {

    //конструктор
    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public  MainPage (WebDriver driver) {
        PageFactory.initElements(driver,  this);
        }


    //МЕНЮ на первой странице
    @FindBy (xpath="//a[contains(@data-id, 'market')]")
    public WebElement mainMenuY;


}
