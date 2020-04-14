package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelPage {
/*
    @FindBy (xpath="//fieldset[contains(@class,'no-offset non-border')]")
    WebElement mainGroup;
*/
    @FindBy (xpath="//DIV[@_ngcontent-c11='']/self::DIV")
    public WebElement minS;

    //поиск кнопки "Оформить"
    @FindBy (xpath="//*[(@class='btn btn-primary btn-large')][contains(text(),'Оформить')]")
    public WebElement sendButtonTwo;

    //конструктор обычный
    public  TravelPage (WebDriver driver) {
        PageFactory.initElements(driver,  this);
        // Wait<WebDriver> wait = new WebDriverWait(driver, 5,4000);//ожидаем появления
        // wait.until(ExpectedConditions.visibilityOf(sendButtonTwo)).click();
    }

 /*   //выбор варианта защиты
    public void selectMainGroup(String menuItem){
        mainGroup.findElement(By.xpath("//h3[contains(text(),'"+menuItem+"']")).click();
    }

  */


}


