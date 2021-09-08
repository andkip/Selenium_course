package steps;

import org.openqa.selenium.By;
import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;
import static org.junit.Assert.assertTrue;


public class TravelInsurancePageSteps {

    @Step("выполнено нажатие на кнопку {0}")
    public void clickButton(String name) {
        String xpath = "//*[contains(text(),'" + name + "')]";
        BaseSteps.getDriver().findElement(By.xpath(xpath)).click();
    }

    @Step("заголовок страницы - Страхование путешественников равен {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new TravelInsurancePage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }
}
