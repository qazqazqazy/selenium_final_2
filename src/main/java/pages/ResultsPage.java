package pages;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class ResultsPage {

    //конструктор
    public ResultsPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
