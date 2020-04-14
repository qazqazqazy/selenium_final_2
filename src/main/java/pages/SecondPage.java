package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SecondPage {

    //находим кнопку оформления онлайн
    @FindBy (xpath="//b[contains(text(),'Оформить онлайн')]")
    public WebElement sendButton;
/*
    //ссылка, не нужно
    public void selectURL (String problemItem){
        SecondPage.findElement(By.xpath(./+"problemItem")).getAttribute("href");
    }
*/
    public  SecondPage (WebDriver driver) {

        PageFactory.initElements(driver,  this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5,4000);//ожидаем появления
        wait.until(ExpectedConditions.visibilityOf(sendButton)); //убрала отсюда .(click);
    }
}
