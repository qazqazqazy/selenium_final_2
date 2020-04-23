import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class MyTestForAllureReport extends BaseSteps {


    @Test
    @Title("Страхование")
    public void testInsurance(){
        MainSteps mainSteps = new MainSteps();
        SecondSteps secondSteps = new SecondSteps();
        TravelSteps travelSteps = new TravelSteps();
        FormSteps formSteps = new FormSteps();


        HashMap<String, String> testData = new HashMap<>();
        //testData.put("Фамилия /Surname","FFFFF");
        testData.put("Имя / Given names","Ruslan");
        testData.put("Дата рождения/B","23.03.2010");

        HashMap<String, String> testDataTwo = new HashMap<>();

        testDataTwo.put("Фамилия","Васильев");
        testDataTwo.put("Имя","Михаил");
        testDataTwo.put("Отчество","Александрович");
        testDataTwo.put("Дата рождения","23.03.1986");

        HashMap<String, String> testDataThree = new HashMap<>();

        testDataThree.put("Серия паспорта","3411");
        testDataThree.put("Номер паспорта","341111");
        testDataThree.put("Кем выдан","Т4444444444444");
        testDataThree.put("Дата выдачи","03.10.2014");
        testDataThree.put("Фамилия /Surname","FFFFF");


        driver.get(baseUrl);

        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Страхование путешественников");

        secondSteps.stepAssertTrueSec();
        secondSteps.stepSendAppButton();
        travelSteps.stepMinS();
        travelSteps.stepSendButtonTwo();
        formSteps.stepFillFields(testData);
        formSteps.stepFieldFree();
        formSteps.stepFillFields(testDataTwo);
        formSteps.stepFieldFree();
        formSteps.stepFillFields(testDataThree);
        formSteps.stepFieldPhone();
        formSteps.stepFieldCard();
        formSteps.checkFillFields(testData);
        formSteps.checkFillFields(testDataTwo);
        formSteps.checkFillFields(testDataThree);
        formSteps.stepNext();
        formSteps.stepCheckMessage();

    }
}
