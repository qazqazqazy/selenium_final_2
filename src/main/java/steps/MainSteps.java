package steps;
import pages.MainPage;
import pages.SecondPage;
import ru.yandex.qatools.allure.annotations.Step;


public class MainSteps  {


    @Step("Выбран пункт меню Маркет")
        public void stepSelectMainMenu() {
        new MainPage(BaseSteps.getDriver()).mainMenuY.click();
        //new MainPage(BaseSteps.getDriver()).mainMenuY.click();
    }

}
