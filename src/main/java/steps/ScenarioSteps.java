package steps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    SecondSteps secondSteps = new SecondSteps();
    SearchSteps searchSteps = new SearchSteps();


    @When("^выбран пукнт меню - Маркет$")
    public void selectMainMenu() {
        mainSteps.stepSelectMainMenu();
    }

    @Then("^Выбран РАЗДЕЛ: ЭЛЕКТРОНИКА$")
    public void electronic() {
        secondSteps.stepSelectSubMenu();
    }

    @When("^Выбрана КАТЕГОРИЯ: ТЕЛЕВИЗОРЫ$")
    public void tv() {
        secondSteps.stepSelectTV();
    }

    @Then("^Нажата кнопка: Все фильтры$")
    public void filters() {
        secondSteps.stepSelectFilters();
    }
    /*
    @When("^Установлена стартовая цена: 20000 рублей$")
    public void startPriceForTV() {
        searchSteps.stepSelectStartPrice();
    }
     */

    @When("^заполняется поле:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> searchSteps.stepFillField(field, value));
    }

    @When("^Выбран производитель LG$")
    public void stepSelectLG() {
        searchSteps.stepSelectLG();
    }
    @When("Выбран производитель Samsung$")
    public void stepSelectSamsung() {
        searchSteps.stepSelectSamsung();
    }

    @Then("^Нажата кнопка: Показать подходящие$")
    public void stepResults() {
        searchSteps.stepClickButtonShowResults();
    }
}