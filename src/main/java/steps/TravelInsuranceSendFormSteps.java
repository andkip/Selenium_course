package steps;

import org.openqa.selenium.By;
import pages.TravelInsuranceSendForm;
import ru.yandex.qatools.allure.annotations.Step;
import static org.junit.Assert.assertTrue;

public class TravelInsuranceSendFormSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value) {
        new TravelInsuranceSendForm().fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value) {
        String actual = new TravelInsuranceSendForm().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("присутствует сообщение об ошибке {0}")
    public void checkErrorMessage(String value) {
        new TravelInsuranceSendForm().checkErrorMessage(value);
    }

    @Step("в поле {0} присутствует ошибка {1}")
    public void checkFieldErrorMessage(String field, String value) {
        new TravelInsuranceSendForm().checkFieldsErrorMessage(field, value);
    }

    @Step("заголовок страницы - Страхование путешественников равен {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new TravelInsuranceSendForm().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("выбран пакет Минимальный")
    public void selectMinimal() {
        new TravelInsuranceSendForm().selectMinimal();
    }

    @Step("выбран пол {0}")
    public void selectGender(String sex) {
        new TravelInsuranceSendForm().gender.findElement(By.xpath("//label[contains(text(),'" + sex + "')]")).click();
    }

}
