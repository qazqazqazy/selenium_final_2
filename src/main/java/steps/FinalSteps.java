package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FinalPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class FinalSteps {


    @Step("Проверка заполнения строки поиска")
    public void stepCheckSearch(){
        //BaseSteps.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //new WebDriverWait(BaseSteps.getDriver(), 10).until( ExpectedConditions.elementToBeClickable(new FinalPage(BaseSteps.getDriver()).searchFieldFT));
        //new FinalPage(BaseSteps.getDriver()).trueElement.click();

        String expected = BaseSteps.getDriver().findElement(By.xpath("//span[contains(@class,'invalid-validate form-control__message')]")).getAttribute("innerText");
        String actual = BaseSteps.getDriver().findElement(By.xpath("//h3//a[contains(text(),'Телевизор')][1]")).getAttribute("innerText");

        //String expected = new FinalPage().firstElement.getAttribute("innerText");
        //String actual = new FinalPage().searchFieldFT.getAttribute("innerText");
        assertTrue(String.format("Текст в поле поиска = [%s]. Ожидалось - [%s]",
                actual, expected), actual.contains(expected));
    }


 /*
    @Step("Проверка заполнения строки поиска")
    public void stepCheckSearch() {
        String expected = new FinalPage(BaseSteps.getDriver()).firstElement.getAttribute("innerText");
        String actual = new FinalPage(BaseSteps.getDriver()).searchFieldF.getAttribute("innerText");
        assertEquals(expected,actual);
    }
  */
}
