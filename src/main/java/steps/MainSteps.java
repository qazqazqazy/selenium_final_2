package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps  {

    @Step("Выбран пункт меню {0}")
        public void stepSelectMainMenu(String menuItem){
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("Выбран раздел {0}")
    public void stepSelectSubMenu(String menuItem){
        new MainPage().selectSubMenu(menuItem);
    }

}
