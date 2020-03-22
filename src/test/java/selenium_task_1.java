import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class selenium_task_1 {

    WebDriver driver; //создаем в полях класса переменную класса Webdriver, названную driver
    String baseUrl; //переменная типа string, названная baseUrl

    @Before //Данный метод выполняется перед каждоым тестом
    public void  beforeMetod(){

        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        //указываем в системной переменной путь к драйверу для хрома - перед началом теста

        baseUrl="http://www.sberbank.ru/ru/person";

        driver = new ChromeDriver(); //инициализируем переменную драйвер. так как мы запускаем в хроме,
        // создаем новый экзампляр класса хромдрайвер

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Имплицитное ожидания для
        // метода findelement. в течение 30 секунд ждет появления элемента с заданным локатором
        driver.manage().window().maximize();//развернем появившееся окно на весь экран
        driver.get(baseUrl);
    }
        //после его выполнения открывается окно браузера, раскрывается на весь экран и происходит переход по ссылке

    @Test
    public void task1() {
        driver.findElement(By.xpath("//span[contains(@class,'lg-menu__text')][contains(text(),'Страхование')]")).click();

        driver.findElement(By.xpath(("//a[contains(text(),'Страхование путешественников')]"))).click();

        // В заданиии есть пункт "Проверить наличие на странице заголовка – Страхование путешественников"
        // Сайт несколько изменился, поэтому просто проверим, что у нас есть на странице текст "до 120 000 евро"
        WebElement search_text  = driver.findElement(By.xpath("//*[text()='Сумма выплаты']//..//h3[@class='kit-heading kit-heading_s']"));
        assertEquals("до 120 000 евро",search_text.getText());

       // driver.findElement(By.xpath(("//b[contains(text(),'Оформить онлайн')]"))).click();

        String problemUrl = driver.findElement(By.xpath("//b[contains(text(),'Оформить онлайн')]/..")).getAttribute("href");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //Имплицитное ожидания
        driver.get(problemUrl);

        driver.findElement(By.xpath("//*[(@class='btn btn-primary btn-large')][contains(text(),'Оформить')]")).click();
        driver.findElement(By.xpath("//*[(@class='btn btn-primary btn-large')]")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5,1000);//ожидаем появления кнопки
        WebElement title = driver.findElement(By.xpath("//div[contains(@class,'sub-legend')][contains(text(),'Введите данные застрахованных латинскими буквами, как в загранпаспорте')]"));
        wait.until(ExpectedConditions.visibilityOf(title));

        fillField(By.id("surname_vzr_ins_0"),"Иванов");
        fillField(By.id("name_vzr_ins_0"),"Руслан");
        fillField(By.id("birthDate_vzr_ins_0"),"23.03.2010");

        fillField(By.id("person_lastName"),"Петров");
        fillField(By.id("person_firstName"),"Михаил");
        fillField(By.id("person_middleName"),"Александрович");

        driver.findElement(By.xpath("//label[contains(text(),'Мужской')]")).click();

        fillField(By.id("passportSeries"),"3411");
        fillField(By.id("passportNumber"),"341111");
        fillField(By.id("documentDate"),"03.10.2014");
        fillField(By.id("documentIssue"),"ТП №1");

       //Проверка полей на корректность  заполнения
        assertEquals("Иванов", driver.findElement(By.xpath("//*[contains(@class,'form-control__container form-control_has-value form-control__focused')]//input[contains(@class,'form-control ng-touched ng-dirty ng-valid')]")).getAttribute("value"));
        assertEquals("Руслан", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        assertEquals("23.03.2010", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));

        assertEquals("Петров", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Михаил", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Александрович", driver.findElement(By.id("person_middleName")).getAttribute("value"));

        assertEquals("3411", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("341111", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("03.10.2014", driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("ТП №1", driver.findElement(By.id("documentIssue")).getAttribute("value"));

    /*

        //Проверить, что текст ошибки соответствует нужному
        assertEquals("Введите адрес электронной почты",
                driver.findElement(By.xpath("//label[contains(@class,'control-label')][contains(text(),'Эл. почта')]/..//span")).getAttribute("innerText"));


    */
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

