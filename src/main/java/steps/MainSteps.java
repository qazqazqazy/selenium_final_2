package steps;
import pages.MainPage;
import pages.SecondPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;


public class MainSteps  {


    @Step("Выбран пункт меню Маркет")
        public void stepSelectMainMenu() {
        new MainPage(BaseSteps.getDriver()).mainMenuY.click();
        //new MainPage(BaseSteps.getDriver()).mainMenuY.click();
        String oldT = BaseSteps.getDriver().getWindowHandle();
        ArrayList<String> newT = new ArrayList<String>(BaseSteps.getDriver().getWindowHandles());
        newT.remove(oldT);
        BaseSteps.getDriver().switchTo().window(newT.get(0));

    }

}
