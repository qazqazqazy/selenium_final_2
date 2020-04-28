package steps;


import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.baseUrl;

public class MainSteps  {

    @Step ("Происходит переход по ссылке")
        public void stepURL() {
        BaseSteps.getDriver().get(baseUrl);
    }

    @Step("Выбран пункт меню {0}")
        public void stepSelectMainMenu(String menuItem){
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("Выбран раздел {0}")
    public void stepSelectSubMenu(String menuItem){
        new MainPage().selectSubMenu(menuItem);
    }

}
