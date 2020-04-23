package steps;

import io.qameta.allure.Step;
import pages.SecondPage;
import pages.TravelPage;

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
