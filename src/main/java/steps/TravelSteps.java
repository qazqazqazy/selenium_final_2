package steps;

import pages.SecondPage;
import pages.TravelPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelSteps extends BaseSteps{


    @Step("Минимальная")
    public void stepMinS(){
        new TravelPage(driver).minS.click();
    }

    @Step("кнопка Оформить")
    public void stepSendButtonTwo(){
        new TravelPage(driver).sendButtonTwo.click();
    }

}
