package steps;

import pages.SecondPage;
import ru.yandex.qatools.allure.annotations.Step;

import static junit.framework.TestCase.assertTrue;

public class SecondSteps  extends BaseSteps{

    @Step("Выполнено нажатие на кнопку - Оформить заявку")
        public void stepSendAppButton(){
            new SecondPage(driver).sendButton.click();
    }

    @Step("Проверка наличия текста")
        public void stepAssertTrueSec(){
        String text = "до 120 000 евро";
        String link = new SecondPage(driver).search_text.getText();
        assertTrue(text.equals(link));
    }

}
