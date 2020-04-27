package steps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.FormPage;
import java.util.HashMap;
import static junit.framework.TestCase.assertTrue;

public class FormSteps extends BaseSteps {

    @Step("Поле {0} заполняется значением {1}")
        public void stepFillField(String field, String value) {
            new FormPage(driver).fillField(field,value);
    }

    @Step("Заполняются поля:")
        public void stepFillFields(HashMap<String,String> fields) {
        fields.forEach(this::stepFillField);
    }
     @Step("Нажатие на свободное поле")
        public void stepFieldFree (){
             new FormPage(driver).str.click();
    }

    @Step("Нажатие на поле 'Телефон'")
    public void stepFieldPhone (){
        new FormPage(driver).phone.click();
    }

    @Step("Выбран пол (Мужской)")
    public void stepFieldCard () {
        new FormPage(driver).card.click();
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String act = new FormPage(driver).getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, act, value),
                act.equals(value));
    }

    @Step("поля заполнены верно")
        public void checkFillFields(HashMap<String, String> fields){
        fields.forEach(this::checkFillField);
    }

    @Step("Нажатие на кнопку 'Продолжить'")
    public void stepNext () {
        new FormPage(driver).next.click();
    }

    @Step("Проверка сообщения об ошибке - выводится текст ошибки 'Поле не заполнено'")
    public void stepCheckMessage(){
        String expected = "Поле не заполнено.";
        String actual = driver.findElement(By.xpath("//span[contains(@class,'invalid-validate form-control__message')]")).getAttribute("innerText");
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actual, expected), actual.contains(expected));
    }
}



