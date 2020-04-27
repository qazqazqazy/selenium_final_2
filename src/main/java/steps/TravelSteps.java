package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SecondPage;
import pages.TravelPage;

public class TravelSteps extends BaseSteps{


    @Step("Выбор суммы страховой защиты (Минимальная)")
    public void stepMinS(){
        new TravelPage(driver).minS.click();
    }

    @Step("Нажатие на кнопку 'Оформить'")
    public void stepSendButtonTwo(){
        //new TravelPage(driver).sendButtonTwo.click();
        new WebDriverWait(driver, 1).until( ExpectedConditions.elementToBeClickable(new TravelPage(driver).sendButtonTwo)).click();
    }

}
