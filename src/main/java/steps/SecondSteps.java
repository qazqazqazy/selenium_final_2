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
}
