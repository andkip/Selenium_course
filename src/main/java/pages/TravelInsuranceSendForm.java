package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class TravelInsuranceSendForm extends BasePageObject {

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surnameOfInsured;

    @FindBy(id = "name_vzr_ins_0")
    WebElement nameOfInsured;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDateOfInsured;

    @FindBy(id = "person_lastName")
    WebElement surname;

    @FindBy(id = "person_firstName")
    WebElement name;

    @FindBy(id = "person_middleName")
    WebElement middleName;

    @FindBy(id = "person_birthDate")
    WebElement birthDate;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(xpath = "//h2")
    public WebElement title;

    @FindBy(xpath = "//h3[contains(text(),'Минимальная')]/../../div")
    public WebElement packageMinimal;

    @FindBy(xpath = "(//div[@class='btn-group'])[2]")
    public WebElement gender;

    public TravelInsuranceSendForm() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        (new WebDriverWait(BaseSteps.getDriver(), 10))
                .until(ExpectedConditions.visibilityOf(title));
    }

    public void selectMinimal() {
        if (!packageMinimal.getAttribute("class").contains("selected")) {
            packageMinimal.click();
        }
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillField(surnameOfInsured, value);
                break;
            case "Имя застрахованного":
                fillField(nameOfInsured, value);
                break;
            case "Дата рождения застрахованного":
                fillField(birthDateOfInsured, value);
                break;
            case "Фамилия страхователя":
                fillField(surname, value);
                break;
            case "Имя страхователя":
                fillField(name, value);
                break;
            case "Отчество страхователя":
                fillField(middleName, value);
                break;
            case "Дата рождения страхователя":
                fillField(birthDate, value);
                break;
            case "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(documentDate, value);
                break;
            case "Кем выдан":
                fillField(documentIssue, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String field)  {
        switch (field) {
            case "Фамилия застрахованного":
                return surnameOfInsured.getAttribute("value");
            case "Имя застрахованного":
                return nameOfInsured.getAttribute("value");
            case "Дата рождения застрахованного":
                return birthDateOfInsured.getAttribute("value");
            case "Фамилия страхователя":
                return surname.getAttribute("value");
            case "Имя страхователя":
                return name.getAttribute("value");
            case "Отчество страхователя":
                return middleName.getAttribute("value");
            case "Дата рождения страхователя":
                return birthDate.getAttribute("value");
            case "Серия паспорта":
                return passportSeries.getAttribute("value");
            case "Номер паспорта":
                return passportNumber.getAttribute("value");
            case "Дата выдачи":
                return documentDate.getAttribute("value");
            case "Кем выдан":
                return documentIssue.getAttribute("value");
            default:
                throw new AssertionError("Поле '" + field + "' не объявлено на странице");
        }
    }

    public void checkErrorMessage(String errorMessage) {
        String xpath = "//div[contains(@class,'alert')]";
        String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }

    public void checkFieldsErrorMessage(String field, String errorMessage) {
        String xpath = "(//span[@class='control-label' and contains(text(),'" + field + "')]//following-sibling::*//span)[2]";
        String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }

}
