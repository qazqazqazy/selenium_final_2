package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ResultsPage;
import ru.yandex.qatools.allure.annotations.Step;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ResultSteps {

    @Step("Проверено, что количество элементов на странице равно 48")
    public void stepCountResults() {
        int expected = 13;
        int count = BaseSteps.getDriver().findElements(By.xpath("//h3//a[contains(text(),'Наушники')]")).size();
        assertEquals(expected, count);
    }

    @Step("Первый элемент списка записан в переменную firstRes")
    public void stepWriteResult(){
        String firstRes = new ResultsPage(BaseSteps.getDriver()).firstElement.getAttribute("innerText");
    }

    @Step("Первый элемент записан в переменную, значение переменное введено в строку поиска")
    public void stepIn(){
        new WebDriverWait(BaseSteps.getDriver(), 10).until( ExpectedConditions.elementToBeClickable(new ResultsPage(BaseSteps.getDriver()).firstElement));
        String firstRes = new ResultsPage(BaseSteps.getDriver()).firstElement.getAttribute("innerText");
        System.out.println("Сохранено наименование элемента: " + firstRes);
        new ResultsPage(BaseSteps.getDriver()).searchFieldF.sendKeys(firstRes);
    }
    @Step("Нажатие на кнопку поиска")
    public void stepFinalClick(){
        new ResultsPage(BaseSteps.getDriver()).find.click();

    }
}
