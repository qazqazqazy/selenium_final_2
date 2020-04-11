import org.junit.Test;
import pages.MainPage;

public class myRefactoringTest extends BaseTest {


    @Test
    public void newInsuranceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Cтрахование путешественников");

    }
}




