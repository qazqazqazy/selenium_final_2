import org.junit.Test;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.SecondPage;
import pages.TravelPage;

import java.util.concurrent.TimeUnit;

public class myRefactoringTest extends BaseTest {


    @Test
    public void newInsuranceTest() {
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Страхование путешественников");

/*      проверим, что у нас есть на странице текст "до 120 000 евро"
        WebElement search_text  = driver.findElement(By.xpath("//*[text()='Сумма выплаты']//..//h3[@class='kit-heading kit-heading_s']"));
        assertEquals("до 120 000 евро",search_text.getText());
*/
        new SecondPage(driver).sendButton.click(); //Нажимаем "Оформить заявку" c SecondPage

        TravelPage travelPage = new TravelPage(driver);
        travelPage.selectMainGroup("Минимальная");
    }
}




