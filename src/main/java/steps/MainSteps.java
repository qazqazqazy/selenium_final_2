package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps extends BaseSteps {

    @Step("Выбран пункт меню {0}")
        public void stepSelectMainMenu(String menuItem){
        new MainPage(driver).selectMainMenu(menuItem);
    }

    @Step("Выбран раздел Страхование путешественников {0}")
    public void stepSelectSubMenu(String menuItem){
        new MainPage(driver).selectSubMenu(menuItem);
    }

}
