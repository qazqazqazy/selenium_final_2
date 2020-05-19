package steps;
import org.aspectj.weaver.patterns.SimpleScope;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SecondPage;
import ru.yandex.qatools.allure.annotations.Step;


public class SecondSteps {

    @Step("Выбран раздел Электроника")
    public void stepSelectSubMenu() {
        new SecondPage(BaseSteps.getDriver()).subMenu.click();
    }

//    @Step("Выбрана категория  Телевизоры")
//    public void stepSelectTV() {
//        new SecondPage(BaseSteps.getDriver()).television.click();
//    }

    @Step("Выбрана категория  Наушники")
    public void stepSelectEarPhones() {
        new SecondPage(BaseSteps.getDriver()).earPh.click();
    }


    @Step("Выбрана кнопка Все фильтры")
    public void stepSelectFilters() {
        new SecondPage(BaseSteps.getDriver()).sendButtonFilters.click();
    }
}
