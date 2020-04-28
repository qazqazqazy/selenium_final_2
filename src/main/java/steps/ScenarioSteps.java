package steps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import pages.FormPage;


public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    SecondSteps secondSteps = new SecondSteps();
    TravelSteps travelSteps = new TravelSteps();
    FormSteps formSteps = new FormSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMainMenu(String menuItem){
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран раздел \"(.+)\"$")
    public void selectSubMenu(String menuItem){
        mainSteps.stepSelectSubMenu(menuItem);
    }

    @Then("^на странице 'Страхование путешественников' присутствует текст 'до 120 000 евро'$")
    public void checkTextOnSecondPage(){
        secondSteps.stepAssertTrueSec();
    }

    @When("^выполнено нажатие на кнопку - Оформить заявку$")
    public void clickSenAppPage(){
        secondSteps.stepSendAppButton();
    }

    @Then("^выбор суммы страховой защиты - Минимальная$")
    public void clickMinS(){
       travelSteps.stepMinS();
    }

    @When("^происходит нажатие на кнопку  - Оформить$")
    public void clickForm(){
        travelSteps.stepSendButtonTwo();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> formSteps.stepFillField(field, value));
    }

    @Then("^происходит нажатие на свободное поле$")
    public void freeField(){
        formSteps.stepFieldFree();
    }

    @Then("^выбран параметр Пол - Мужской$")
    public void finalCard(){
        formSteps.stepFieldCard();
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> formSteps.checkFillField(field, value));
    }
    @When("^происходит нажатие на кнопку  - Продолжить$")
    public void clickNext(){
        formSteps.stepNext();
    }

    @Then("^на странице присутствует сообщение - Поле не заполнено$")
    public void checkErrorMessage(){
        formSteps.stepCheckMessage();

    }

}
