package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class FormPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'sub-legend')]")
    public WebElement title;

    @FindBy(id = "surname_vzr_ins_0")
    WebElement lastNameD;

    @FindBy(id = "name_vzr_ins_0")
    WebElement nameD;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDateD;

    @FindBy(xpath = "//*[contains(text(),'Страхователь')]")
    public WebElement str;

    @FindBy(id = "person_lastName")
    WebElement lastName;

    @FindBy(id = "person_firstName")
    WebElement firstName;

    @FindBy(id = "person_middleName")
    WebElement middleName;

    @FindBy(id = "person_birthDate")
    WebElement birthDate;

    @FindBy(id = "passportSeries")
    WebElement passportSeriesP;

    @FindBy(id = "passportNumber")
    WebElement passportNumberP;

    @FindBy(id = "documentIssue")
    WebElement documentIssueP;

    @FindBy(id = "documentDate")
    WebElement documentDateP;

    @FindBy(xpath = "//*[contains(text(),'Мобильный телефон')]")
    public WebElement phone;

    @FindBy(xpath = "//label[contains(text(),'Мужской')]")
    public WebElement card;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]/.")
    public WebElement next;
    protected static WebDriver driver;

    //инициализация
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(title));
    }

    //метод для заполнения полей
    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия /Surname":
                fillField(lastNameD, value);
                break;
            case  "Имя / Given names":
                fillField(nameD, value);
                break;
            case  "Дата рождения/B":
                fillField(birthDateD, value);
                break;

            case  "Фамилия":
                fillField(lastName, value);
                break;
            case  "Имя":
                fillField(firstName, value);
                break;
            case  "Отчество":
                fillField(middleName, value);
                break;
            case  "Дата рождения":
                fillField(birthDate, value);
                break;
            case  "Серия паспорта":
                fillField(passportSeriesP, value);
                break;
            case  "Номер паспорта":
                fillField(passportNumberP, value);
                break;
            case  "Кем выдан":
                fillField(documentIssueP, value);
                break;
            case  "Дата выдачи":
                fillField(documentDateP, value);
                break;
            case  "Мобильный телефон":
                fillField(phone, value);
                break;

            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия /Surname":
                return lastNameD.getAttribute("value");
            case  "Имя / Given names":
                return nameD.getAttribute("value");
            case  "Дата рождения/B":
                return birthDateD.getAttribute("value");

            case  "Фамилия":
                return lastName.getAttribute("value");
            case  "Имя":
                return firstName.getAttribute("value");
            case  "Отчество":
                return middleName.getAttribute("value");
            case  "Дата рождения":
                return birthDate.getAttribute("value");
            case  "Серия паспорта":
                return passportSeriesP.getAttribute("value");
            case  "Номер паспорта":
                return passportNumberP.getAttribute("value");
            case  "Кем выдан":
                return documentIssueP.getAttribute("value");
            case  "Дата выдачи":
                return documentDateP.getAttribute("value");
            case  "Мобильный телефон":
                return phone.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }
}
