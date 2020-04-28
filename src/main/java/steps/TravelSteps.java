package steps;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TravelPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelSteps {


    @Step("Выбор суммы страховой защиты (Минимальная)")
    public void stepMinS(){
        new TravelPage().minS.click();
    }

    @Step("Нажатие на кнопку 'Оформить'")
    public void stepSendButtonTwo(){
        //new TravelPage(driver).sendButtonTwo.click();
        new WebDriverWait(BaseSteps.getDriver(), 1).until( ExpectedConditions.elementToBeClickable(new TravelPage().sendButtonTwo)).click();    }

}
