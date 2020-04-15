package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

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

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(title));
    }

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
     protected void fillField (WebElement element, String value) {
            element.clear();
            element.sendKeys(value);
            }


/*
    @FindBy(css = "input.checkbox")
    public WebElement checkbox;

 */
}
