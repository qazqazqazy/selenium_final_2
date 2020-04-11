package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy (xpath="//ul[contains(@class, 'lg-menu__list')]")
    WebElement mainMenu;


    @FindBy (xpath="(//DIV[@class='kit-row'])[8]")
    WebElement subMenu;

    public  MainPage (WebDriver driver) {
        PageFactory.initElements(driver,  this);
        }

        public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//..//../span[contains(text(),'"+menuItem+"')]")).click();
        }


         public void selectSubMenu(String menuItem){
         mainMenu.findElement(By.xpath(".//li//a[contains(text(),'"+menuItem+"')]")).click();

        }
}
