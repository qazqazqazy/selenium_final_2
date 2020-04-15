import org.junit.Test;
import org.openqa.selenium.By;
import pages.FormPage;
import pages.MainPage;
import pages.SecondPage;
import pages.TravelPage;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class myRefactoringTest extends BaseTest {


    @Test
    public void newInsuranceTest() {
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Страхование путешественников");

/*      проверим, что у нас есть на странице текст "до 120 000 евро"
        assertEquals("до 120 000 евро",search_text.getText());
*/
        String text = "до 120 000 евро";
        String link = new SecondPage(driver).search_text.getText();
        assertTrue(text.equals(link));


        new SecondPage(driver).sendButton.click(); //Нажимаем "Оформить заявку" c SecondPage
        new TravelPage(driver).minS.click();//выбираем кнопку "Минимальная"
/*
        TravelPage travelPage = new TravelPage(driver);
        travelPage.selectMainGroup("Минимальная");
*/
        new TravelPage(driver).sendButtonTwo.click();//выбираем кнопку "Оформить"

        FormPage formPage = new FormPage(driver);

        formPage.fillField("Фамилия /Surname", "Ivanov");
        formPage.fillField("Имя / Given names", "Ruslan");
        formPage.fillField("Дата рождения/B", "23.03.2010");

        new FormPage(driver).str.click();

        formPage.fillField("Фамилия", "Васильев");
        formPage.fillField("Имя", "Михаил");
        formPage.fillField("Отчество", "Александрович");
        formPage.fillField("Дата рождения", "23.03.1986");

        new FormPage(driver).str.click();

        formPage.fillField("Серия паспорта", "3411");
        formPage.fillField("Номер паспорта", "341111");
        formPage.fillField("Кем выдан", "Т4444444444444");
        formPage.fillField("Дата выдачи", "03.10.2014");

        new FormPage(driver).phone.click();
        new FormPage(driver).card.click();




        
        new FormPage(driver).next.click();

        String expected = "Поле не заполнено.";
        String actual = driver.findElement(By.xpath("//span[contains(@class,'invalid-validate form-control__message')]")).getAttribute("innerText");
        assertTrue(expected.equals(actual));
    }
}




