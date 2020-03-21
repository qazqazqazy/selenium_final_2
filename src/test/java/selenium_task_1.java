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

        driver.findElement(By.xpath(("//a[contains(text(),'Оформить онлайн')]"))).click();
        //Далее не срабатывает никакое ожидание и никакой xpath
        driver.findElement(By.xpath("//p[contains(text(),'Необходимый минимум для оплаты медицинской помощи за границей')]")).click();

 /*     Wait<WebDriver> wait = new WebDriverWait(driver, 5,1000);//ожидаем появления элемента
         WebElement sndtext = driver.findElement(By.xpath("//div[contains(@class,'circle')]//..//a[contains(text(),'Выбор полиса')]"));
        //ждем, пока появится этот элемент (сам элемент задан строчкой выше)
        wait.until(ExpectedConditions.visibilityOf(sndtext));

                driver.findElement(By.xpath("//div[contains(@class,'online-card-program selected')]")).click();

*/
 /*     WebElement title = driver.findElement(By.xpath("//div[@class='product-image']"));
        wait.until(ExpectedConditions.visibilityOf(title));

        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-large']")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Необходимый минимум для оплаты медицинской помощи за границей')]")).click();
*/

    /*
        fillField(By.name("LastName"),"Иванов"); //вызываем метод заполнения поля для фамилии
        fillField(By.name("FirstName"),"Иван");
        fillField(By.name("MiddleName"),"Иванович");

        //из выпадающего списка выбираем видимое значение "Москва"
        new Select(driver.findElement(By.name("Region"))).selectByVisibleText("Москва");

        fillField(By.name("Comment"),"AUTOTEST");
        fillField(By.name("Email"),"1111wrongsymbols");

        driver.findElement(By.xpath("//input[@class='checkbox']")).click(); //ставим чекбокс
        driver.findElement(By.id("button-m")).click();

        //Проверить, что текст ошибки соответствует нужному
        assertEquals("Введите адрес электронной почты",
                driver.findElement(By.xpath("//label[contains(@class,'control-label')][contains(text(),'Эл. почта')]/..//span")).getAttribute("innerText"));

        //Проверка других полей
        assertEquals("Иванов", driver.findElement(By.name("LastName")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.name("FirstName")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.name("MiddleName")).getAttribute("value"));


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

