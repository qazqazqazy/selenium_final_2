package steps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    SecondSteps secondSteps = new SecondSteps();


    @When("^выбран пукнт меню - Маркет$")
    public void selectMainMenu() {
        mainSteps.stepSelectMainMenu();
    }

    @Then("^выбран РАЗДЕЛ - ЭЛЕКТРОНИКА$")
    public void  electronic() {
        secondSteps.stepSelectSubMenu();

    }

}