package steps;
import org.graalvm.compiler.virtual.phases.ea.PartialEscapeClosure;
import pages.FinalPage;
import ru.yandex.qatools.allure.annotations.Step;


import static junit.framework.TestCase.assertTrue;

public class FinalSteps {


        @Step("поле {0} заполнено значением {1}")
        public void checkFillField(String field, String value){
            String act = new FinalPage().getFillField(field); //Получаем значение из поля м записываем в переменную
            assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, act, value),
                    act.equals(value));
            
        }

        @Step("Проверка соответствия")
        public void checkFinal(){
        String nameOfFirstElement = new FinalPage().firstElement.getAttribute("innerText");
        new FinalSteps().checkFillField("Строка поиска",nameOfFirstElement);
        //System.out.println("nameOfFirstElement: " + nameOfFirstElement);

        }
}
