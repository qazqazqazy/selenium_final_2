package steps;

import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.HashMap;

public class SearchSteps {

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        new SearchPage().fillField(field,value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String,String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("Выбран производитель Beats")
    public void stepSelectBeats() {
        new SearchPage(BaseSteps.getDriver()).prodBeats.click();
    }



    @Step("Нажата кнопка: Показать подходящие")
    public void stepClickButtonShowResults() {
        new SearchPage(BaseSteps.getDriver()).next.click();
    }

}



