package steps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ResultsPage;


public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    SecondSteps secondSteps = new SecondSteps();
    SearchSteps searchSteps = new SearchSteps();
    ResultSteps resultSteps = new ResultSteps();
    FinalSteps finalSteps = new FinalSteps();

    @When("^выбран пукнт меню - Маркет$")
    public void selectMainMenu() {
        mainSteps.stepSelectMainMenu();
    }

    @Then("^Выбран РАЗДЕЛ: ЭЛЕКТРОНИКА$")
    public void electronic() {
        secondSteps.stepSelectSubMenu();
    }

    @When("^Выбрана КАТЕГОРИЯ: НАУШНИКИ$")
    public void phones() {
        secondSteps.stepSelectEarPhones();
    }

    @Then("^Нажата кнопка: Все фильтры$")
    public void filters() {
        secondSteps.stepSelectFilters();
    }

    @When("^заполняется поле:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> searchSteps.stepFillField(field, value));
    }


    @When("Выбран производитель Beats$")
    public void stepSelectprodBeats() {
        searchSteps.stepSelectBeats();
    }

    @Then("^Нажата кнопка: Показать подходящие$")
    public void stepResults() {
        searchSteps.stepClickButtonShowResults();
    }

    @When("^Проверено количество элементов на странице$")
    public void stepCountAll(){
        resultSteps.stepCountResults();
    }

    @Then("^Первый элемент списка записан в переменную firstRes$")
    public void stepWriteRes () {
        resultSteps.stepWriteResult();
    }

    @Then("^Сохраненное значение введено в строку поиска$")
    public void stepTesting () {
        resultSteps.stepIn();
    }

    @Then("^Выполнено нажатие на кнопку: Найти$")
    public void stepFinal () {
        resultSteps.stepFinalClick();
    }

    @Then("^Проверено заполнение стрки поиска$")
    public void stepFinalTwo () {
        finalSteps.checkFinal();
        System.out.println("Тест успешно завершён");
    }
}

