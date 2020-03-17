import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class insurance_test {

    WebDriver driver; //создаем в полях класса переменную класса Webdriver, названную driver
    String baseUrl; //переменная типа string, названная baseUrl

    @Before //Данный метод выполняется перед каждоым тестом
    public void  beforeMetod(){

        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        //указываем в системной переменной путь к драйверу для хрома - перед началом теста
        baseUrl="http://www.rgs.ru\n";  //вставляем в начало
        driver = new ChromeDriver(); //инициализируем переменную драйвер. так как мы запускаем в хроме,
        //// создаем новый экзампляр класса хромдрайвер
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Имплицитное ожидания для
        // метода findelement. в течение 30 секунд ждет появления элемента с заданным локатором
        driver.manage().window().maximize();//развернем появившееся окно на весь экран
       driver.get(baseUrl);
    }
    // после его выполнения открывается окно браузера, раскрывается на весь экран и происходит переход по ссылке

    @Test
    public void testInsurance() {

        driver.findElement(By.xpath("//a[contains(text(),'Меню')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'rgs-main-menu-category')]//*[contains(text(),'ДМС')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5,1000);//ожидаем появления кнопки

        WebElement sndBtn = driver.findElement(By.xpath(("//a[contains(// text(),'Отправить заявку')]")));
                //ждем, пока появится этот элемент (сам элемент задан строчкой выше)

                wait.until(ExpectedConditions.visibilityOf(sndBtn)).click();

        //Добавим ожидание на появление всплывающего окна
        WebElement title = driver.findElement(By.xpath("//h4[@class='modal-title']"));
        wait.until(ExpectedConditions.visibilityOf(title));

                //Проверка, что текст заголовка соответствует ожидаемому
       assertEquals("Заявка на добровольное медицинское страхование",title.getText());

       fillField(By.name("LastName"),"Иванов"); //вызываем метод заполнения поля для фамилии
        fillField(By.name("FirstName"),"Иванов");
        fillField(By.name("MiddleName"),"Иванов");

        //из выпадающего списка выбираем видимое значение "Москва"
        new Select(driver.findElement(By.name("Region"))).selectByVisibleText("Москва");

        fillField(By.name("Comment"),"AUTOTEST");
        fillField(By.name("Comment"),"1111wrongsymbols");

        driver.findElement(By.xpath("//input[@class='checkbox']")); //ставим чекбокс
         driver.findElement(By.id("button-m")).click();

        //Проверить, что текст ошибки соответствует нужному
        assertEquals("Введите адрес электронной почты", driver.findElement(By.xpath("//*[text()='Эл. почта']/..//span[@class='validation-error-text']")));

        //Проверка других полей
        assertEquals("Иванов", driver.findElement(By.name("LastName")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.name("FirstName")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.name("MiddleName")).getAttribute("value"));
    }

    //создадим метод, который будет заполнять поле
    public void fillField(By locator, String value) {
        driver.findElement(locator).clear(); //очистили найденное поле
        driver.findElement(locator).sendKeys(value); //заполнили поле значением, поданным на вход


    }

    @After //Данный метод выполняется после каждого теста
    public void afterTest() {
    driver.quit(); //закроем окно браузера
    }

}
